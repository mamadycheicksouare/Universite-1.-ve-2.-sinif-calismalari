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
    <title>Homepage</title>
    <style>
        
        @keyframes bounceAndChangeColor {
            0%, 20%, 40%, 60%, 80%, 100% {
                transform: translateY(0);
            }
            10% {
                transform: translateY(-20px);
                color: red;
            }
            30% {
                transform: translateY(-20px);
                color: yellow;
            }
            50% {
                transform: translateY(-10px);
                color: green;
            }
            70% {
                transform: translateY(-10px);
                color: black;
            }
        }
        

        .animated-welcome {
            margin-top: 120px;
            display: inline-block;
            animation: bounceAndChangeColor 4s infinite;
        }

        p{
            font-size: 50px;
        }

        
        
    </style>
    
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
                        <a class="nav-link" href="home.php"><b><u>Home</u></b></a>
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


    


    <div class="container mt-5 text-center">
        <h3 class="animated-welcome">Welcome to our website!</h3>
    </div>



    <div class="container mt-5 text-center">
        <p>The best clothes shop in the Republic of TÜRKİYE  <img src="../images/tc.jpg" alt="Turkish Flag" width="100" height="100" id="turkishFlag"></p>
        <p id="dynamicText" >We are a <span style="color:blue" id="changingText">clothes shop</span></p>
    </div>


    
     <div class="container mt-5">
        <h2 class="text-center mb-4"> Our best-sellers</h2>
        <div id="imageSlider" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="../images/1.jpg" class="d-block w-100" alt="Image 1">
                </div>
                <div class="carousel-item">
                    <img src="../images/20.jpg" class="d-block w-100" alt="Image 2">
                </div>
                <div class="carousel-item">
                    <img src="../images/1.jpg" class="d-block w-100" alt="Image 3">
                </div>
                <div class="carousel-item">
                    <img src="../images/20.jpg" class="d-block w-100" alt="Image 4">
                </div>
            </div>
            <a class="carousel-control-prev" href="#imageSlider" role="button" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </a>
            <a class="carousel-control-next" href="#imageSlider" role="button" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </a>
        </div>
    </div>


    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="..." crossorigin="anonymous"></script>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            
            const replacements = ['Company', 'Family','clothes shop'];

            const dynamicTextElement = document.getElementById('dynamicText');
            const changingTextElement = document.getElementById('changingText');

            
            function changeText(index) {
                const textToDisplay = replacements[index];
                changingTextElement.textContent = ''; 

                for (let i = 0; i < textToDisplay.length; i++) {
                    setTimeout(function () {
                        changingTextElement.textContent += textToDisplay[i];
                        if (i === textToDisplay.length - 1) {
                            changingTextElement.classList.add('blue-text');
                        }
                    }, i * 100); 
                }
            }

            
            changeText(0);

            
            let currentIndex = 1;
            setInterval(function () {
                changingTextElement.classList.remove('blue-text');
                setTimeout(function () {
                    changeText(currentIndex);
                    currentIndex = (currentIndex + 1) % replacements.length;
                }, 500);
            }, 3000);
        });
    </script>

</body>
</html>
