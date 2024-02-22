<?php

$name = $email = $phone = $password = $username = "";
$nameError = $emailError = $phoneError = $registrationSuccess = $passwordError = $usernameError = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $password = $_POST['password'];
    $username = $_POST['username'];
    
    if (empty($name)) {
        $nameError = "Name is required";
    }

    if (empty($email)) {
        $emailError = "Email is required";
    }

    if (empty($phone)) {
        $phoneError = "Phone number is required";
    }

    if (empty($password)) {
        $passwordError = "Password is required";
    } elseif (strlen($password) < 8) {
        $passwordError = "Your password should be at least 8 characters";
    }

    if (empty($username)) {
        $usernameError = "Username is required";
    }

    
    if (empty($nameError) && empty($emailError) && empty($phoneError) && empty($passwordError) && empty($usernameError)) {
        
        $host = "localhost";
        $dbUsername = "root";
        $dbPassword = "*******************";
        $dbName = "project";

        $conn = new mysqli($host, $dbUsername, $dbPassword, $dbName);

        
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

    
        $checkEmailQuery = "SELECT * FROM users WHERE email='$email'";
        $result = $conn->query($checkEmailQuery);

        if ($result->num_rows > 0) {
            
            $emailError = "Email is already registered";
        } else {
            
            $insertQuery = "INSERT INTO users (name, email, phone, password, username) VALUES ('$name', '$email', '$phone', '$password', '$username')";

            if ($conn->query($insertQuery) === TRUE) {
                $registrationSuccess = "Successful registration!";
                session_start();
                $_SESSION['registration_success'] = true;

                
                echo '<script>
                        alert("Successful registration!");
                        setTimeout(function() {
                            window.location.href = "login.php";
                        }, 1); 
                      </script>';
                exit();
            } else {
                echo "Error: " . $insertQuery . "<br>" . $conn->error;
            }
        }

        $conn->close();
    }
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
    <title>Register</title>
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
                    <li class="nav-item active ">
                        <a class="nav-link" href="home.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.php">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.php">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.php">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


     
    <div style ="margin-top:150px" >
     <!-- kayit Form -->
    <div class="container mb-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-dark text-white">
                        <center>Register</center>
                    </div>
                    <div class="card-body ">
                        <form method="post">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name"  >
                                <span style="color:red"> <?php echo $nameError; ?></span>
                            </div>
                            
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" >
                                <span style="color:red"> <?php echo $emailError; ?></span>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone Number</label>
                                <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter your phone number"  >
                                <span style="color:red"> <?php echo $phoneError; ?></span>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Choose a password"  >
                                <span style="color:red"> <?php echo $passwordError; ?></span>
                            </div>
                            <div class="mb-3">
                                <label for="username" class="form-label">Username</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Choose a username"  >
                                <span style="color:red"> <?php echo $usernameError; ?></span>
                            </div>
                            <button type="submit" class="btn btn-dark btn-block">Register</button>
                            
                                <span style="color:green"><?php echo $registrationSuccess; ?></span><br>
                                
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="..." crossorigin="anonymous"></script>
</body>
</html>
