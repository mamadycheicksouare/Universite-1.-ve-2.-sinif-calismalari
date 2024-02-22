<?php
session_start();

if (isset($_GET['email'])) {
    
    $host = "localhost";
    $dbUsername = "root";
    $dbPassword = "************";
    $dbName = "project";

    $conn = new mysqli($host, $dbUsername, $dbPassword, $dbName);

    
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $email = $_GET['email'];

    
    $deleteSql = "DELETE FROM users WHERE email = '$email'";

    if ($conn->query($deleteSql) === TRUE) {
        
        
        header("Location: login.php"); 
        
        exit();
    } else {
        
        echo 'Error: ' . $conn->error;
        exit();
    }
} else {
    
    echo 'Invalid request';
    exit();
}
?>
