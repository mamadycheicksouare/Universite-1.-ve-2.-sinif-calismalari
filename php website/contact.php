
<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $name = $_POST["name"];
    $email = $_POST["email"];
    $message = $_POST["message"];

    

    
    $servername = "localhost"; 
    $username = "root";     
    $password = "*************";      
    $dbname = "project";   

    $conn = new mysqli($servername, $username, $password, $dbname);

    
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }


    $sql = "INSERT INTO messages (name, email, message) VALUES (?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("sss", $name, $email, $message);

    if ($stmt->execute() === false) {
        die("Error: " . $stmt->error);
    }

    $successMessage = "Your message is submitted successfully. We'll reply soon!";

    
    $stmt->close();
    $conn->close();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="MAMADY CHEICK SOUARE">
    <meta name="Keywords" content="Sport, shopping, online">
    <meta name="Description" content="This website .............">
    <title>Contact</title>
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
                        <a class="nav-link" href="contact.php"><b><u>Contact Us</u></b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.php">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div  style="margin-top: 150px;">
     
    
     <div class="container mt-5 mb-5">
        <div class="row">
            <div class="col-md-6">
                <h2>Contact Information</h2>
                <p><strong>Email:</strong> mamadycheicksouare@gmail.com</p>
                <p><strong>Phone:</strong> +90 555555555555</p>
            </div>
        </div>
    </div>

    
    <div class="container mt-5 mb-5">
        <div class="row">
            <div class="col-md-6">
                <p><strong>Follow us on:</strong></p>
                <ul class="list-inline">
                    <li class="list-inline-item">
                        <a href="https://www.facebook.com/" target="_blank">
                        <i style= "color: black;" class="fa-brands fa-facebook"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://www.instagram.com/" target="_blank">
                        <i style= "color: black;" class="fa-brands fa-instagram"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://www.linkedin.com/" target="_blank">
                        <i style= "color: black;" class= "fa-brands fa-linkedin"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    </div>


    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header bg-dark text-white">
                        Contact Us
                    </div>
                    <div class="card-body">
                    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                            <div class="mb-3">
                                <label for="name" class="form-label">Your Name</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Your Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="mb-3">
                                <label for="message" class="form-label">Your Message</label>
                                <textarea class="form-control" id="message" name="message" rows="4" required></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div  style="width:20%">

       <!-- Google Maps icin rastgele bir harita ornek -->
       <div class="container mt-5 mb-5">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d396426.43620928345!2d-74.25908651580803!3d40.69766319358306!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY!5e0!3m2!1sen!2sus!4v1639321531003!5m2!1sen!2sus" width="100%" height="400" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>

    </div >

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="..." crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" integrity="sha384-JyZcAMolZ0bFPJLeL4AQwp7JCf7OFg2fUe3Py1zCF41ZBWT7ks1On6lFBouIcZ/Q" crossorigin="anonymous"></script>
    <script>
        
        window.onload = function() {
            var successMessage = "<?php echo $successMessage; ?>";
            if (successMessage !== "") {
                alert(successMessage);
            }
        };
    </script>

</body>
</html>
