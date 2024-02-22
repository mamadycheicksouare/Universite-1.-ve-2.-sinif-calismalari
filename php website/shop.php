<?php
session_start();

if (!isset($_SESSION['loggedIn']) || $_SESSION['loggedIn'] !== true) {
    header("Location: home.php"); 
    exit();
}

$host = "localhost";
$dbUsername = "root";
$dbPassword = "****************";
$dbName = "project";

$conn = new mysqli($host, $dbUsername, $dbPassword, $dbName);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$email = $_SESSION['email'];
$sql = "SELECT username FROM users WHERE email = '$_SESSION[email]'";
$result = $conn->query($sql);

if ($result->num_rows == 1) {
    $row = $result->fetch_assoc();
    $username = $row['username'];
} else {
    $username = "Guest";
}

if (isset($_POST["remove_from_cart"])) {
    $removeID = $_POST["remove_id"];

    foreach ($_SESSION["cart"] as $key => $value) {
        if ($value['id'] == $removeID) {
            unset($_SESSION["cart"][$key]); 
            break;
        }
    }
}

if (isset($_POST["add_to_cart"])) {
    $productID = $_GET["id"];
    $productName = $_POST["hidden_name"];
    $productPrice = $_POST["hidden_price"];
    $productQuantity = $_POST["quantity"];

    $itemArray = array(
        'id' => $productID,
        'name' => $productName,
        'price' => $productPrice,
        'quantity' => $productQuantity,
    );

    if (isset($_SESSION["cart"])) {
        $itemExist = false;
        foreach ($_SESSION["cart"] as $key => $value) {
            if ($value['id'] == $productID) {
                $_SESSION["cart"][$key]['quantity'] += $productQuantity;
                $itemExist = true;
                break;
            }
        }

        if (!$itemExist) {
            array_push($_SESSION["cart"], $itemArray);
        }
    } else {
        $_SESSION["cart"] = array($itemArray);
    }
}

if (isset($_POST["delete_account"])) {
    echo '<script>
            var confirmDelete = confirm("Are you sure you want to delete your account?");
            if (confirmDelete) {
                window.location.href = "delete_account.php?email=' . $email . '";
            }
          </script>';
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="MAMADY CHEICK SOUARE">
    <meta name="Keywords" content="Sport, shopping, online">
    <meta name="Description" content="This website .............">
    <title>Shopping</title>
    <script>
        function confirmLogout() {
            var confirmLogout = confirm("Are you sure you want to log out?");
            if (confirmLogout) {
                window.location.href = "login.php";
            }
        }

        function deleteAccount(email) {
            //  AJAX
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var response = this.responseText;
                    if (response === 'success') {
                        alert('Account deleted successfully.');
                        window.location.href = 'login.php';
                    } else {
                        alert('Error deleting account: ' + response);
                    }
                }
            };
            xhttp.open('GET', 'delete_account.php?email=' + email, true);
            xhttp.send();
        }

        var deleteConfirmation = document.getElementById('delete-confirmation');
        if (deleteConfirmation) {
            var confirmDelete = confirm('Are you sure you want to delete your account?');
            if (confirmDelete) {
                var userEmail = <?php echo json_encode($email); ?>;
                deleteAccount(userEmail);
            }
        }
    </script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="home.php">
                <img src="../images/logo.png" alt="Your Logo" height="50">
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.php">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.php">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="confirmLogout()">Log out</a>
                    </li>
                    <li class="nav-item">
                        <form method="post" action="#">
                            <button type="submit" name="delete_account" class="btn btn-danger">Delete My Account</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <p style="font-size:40px; margin-top:130px; margin-left:20px">Welcome, <b><?php echo $username; ?>!</b></p>

    <div class="container">
        <div class="row">
            <?php
            $query = "SELECT ct.name AS category_name, p.* FROM products p JOIN category ct ON p.category_id = ct.id ";
            $result1 = $conn->query($query);
            if ($result1->num_rows > 0) {
                while ($row1 = $result1->fetch_assoc()) {
            ?>
                    <div class="col-md-4 mb-4">
                        <form method="post" action="shop.php?action=add&id=<?php echo $row1["id"]; ?>">
                            <div style="border: 1px solid black; background-color: gray; border-radius: 5px; height: 100%;">
                                <div class="d-flex flex-column align-items-center justify-content-between h-100 p-3">
                                    <img src="<?php echo $row1["path"]; ?>" class="img-responsive" style="max-width: 100%; max-height: 100px; object-fit: contain;"><br>
                                    <h4 class="text-dark text-center mb-3"><?php echo $row1["name"]; ?> </h4>
                                    <p class="text-dark text-center mb-3"><b>Category: </b><?php echo $row1["category_name"]; ?></p>
                                    
                                    <h4 class="text-dark text-center"><?php echo $row1["price"]; ?> Tl </h4>
                                    <input type="text" name="quantity" class="form-control" value="1"><br>
                                    <input type="hidden" name="hidden_name" value="<?php echo $row1["name"]; ?>">
                                    <input type="hidden" name="hidden_price" value="<?php echo $row1["price"]; ?>">
                                    <input type="submit" name="add_to_cart" style="margin-top:5px;" class="btn btn-success" value="Add to Cart">
                                </div>
                            </div>
                        </form>
                    </div>
            <?php
                }
            }
            ?>
        </div>
    </div>

    <div class="container mt-4">
        <h2>Shopping Cart</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <?php
                if (isset($_SESSION['cart']) && !empty($_SESSION['cart'])) {
                    $total = 0;
                    foreach ($_SESSION['cart'] as $key => $value) {
                ?>
                        <tr>
                            <td><?php echo $value['name']; ?></td>
                            <td><?php echo $value['quantity']; ?></td>
                            <td><?php echo $value['price']; ?> Tl</td>
                            <td><?php echo $value['quantity'] * $value['price']; ?> Tl</td>
                            <td>
                                <form method="post" action="shop.php">
                                    <input type="hidden" name="remove_id" value="<?php echo $value['id']; ?>">
                                    <button type="submit" name="remove_from_cart" class="btn btn-danger">Remove</button>
                                </form>
                            </td>
                        </tr>
                <?php
                        $total += ($value['quantity'] * $value['price']);
                    }
                } else {
                ?>
                    <tr>
                        <td colspan="5" class="text-center">Your cart is empty</td>
                    </tr>
                <?php
                }
                ?>
            </tbody>
        </table>
        <h4>Total Amount: <?php echo $total; ?> Tl</h4>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="..." crossorigin="anonymous"></script>
</body>

</html>
