<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $email = $_POST['email'];
    $password = $_POST['password'];


    $host = "localhost";
    $dbUsername = "root";
    $dbPassword = "**************";
    $dbName = "project";

    $conn = new mysqli($host, $dbUsername, $dbPassword, $dbName);

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

if (isset($_POST['rememberMe'])) {

    setcookie('rememberedEmail', $email, time() + (86400), "/");
}

    
    $sql = "SELECT * FROM users WHERE email = '$email' and  password = '$password'";
    $result = $conn->query($sql);

    if ($result->num_rows ==1 ) {
        session_start();
        $_SESSION['loggedIn'] = true;
        $_SESSION['email'] = $email;
        
        
           
        header("Location: shop.php");
            exit();
        } 
     else {
        // Email yok
        $incorrectInfo = "Your information is incorrect";
        
    }

    
    $conn->close();
}


$rememberedEmail = isset($_COOKIE['rememberedEmail']) ? $_COOKIE['rememberedEmail'] : "";
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
    <title>Login</title>
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
                </ul>
            </div>
        </div>
    </nav>

    
    <div style="margin-top:150px">
        <!-- Login formu -->
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-dark text-white">
                            <center>WELCOME</center>
                        </div>
                        <div class="card-body">
                            <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="text" class="form-control" id="email" name="email" value="<?php echo $rememberedEmail; ?>"  required placeholder="Enter your email">
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" required placeholder="Enter your password">
                                </div>
                                <div class="mb-3 form-check">
                                    <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                                    <label class="form-check-label" for="rememberMe">Remember Me</label>
                                </div>
                                <button type="submit" class="btn btn-dark btn-block">Login</button>
                            </form>
                            <p class="mt-3 text-center">Don't have an account? <a href="register.php">Create one</a></p>
                            <?php if (isset($incorrectInfo)): ?>
                                <span style="color: red;"><?php echo $incorrectInfo; ?></span>
                            <?php endif; ?>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="text-center mt-4">
        <p>&copy; 2023 MAMADY CHEICK SOUARE. All rights reserved.</p>
    </footer>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="..." crossorigin="anonymous"></script>
</body>
</html>
