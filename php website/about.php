<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/about.css">
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="MAMADY CHEICK SOUARE">
    <meta name="Keywords" content="Sport, shopping, online">
    <meta name="Description" content="This website .............">
    <title>About us</title>
    <style>

            
    .fade-in {
        opacity: 0;
        transition: opacity 1.3s ease-in-out;
    }

    .fade-in.show {
        opacity: 1;
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
                        <a class="nav-link" href="home.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.php"><b><u>About Us</u></b></a>
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

    
    <!--*****************************************************************************************-->
    <div style="margin-top:150px">


    <div class="container mt-5">
        <h2 class="text-center mb-4 fade-in" id="aboutUsTitle">About Us</h2>
        <div class="row">
            <div class="col-md-4 fade-in" id="aboutUsImageContainer1">
                <img src="../images/logo.png" alt="About Us Image 1" class="img-fluid mb-4">
            </div>
            <div class="col-md-8 fade-in" id="aboutUsTextContainer1">
                <p class="lead">
                    Ce site a été creé par MAMADY CHEICK SOUARE dans le but de facilité l'avhat des produits et d'atteindre un maximum de clients
                </p>
                <p>
                    Vous y trouverez beaucoup de produits de qualité en quantité pour satisfaire vos besoins 
                </p>
                <p>
                    Depuis plus de 10 ans nous nous imposons comme un leader mondial de la vente des habits et des chaussures
                </p>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-8 fade-in" id="aboutUsTextContainer2">
                <p class="lead">
                    Alors n'hesitez pas a acheter chez votre satisfaction est notre plus gros desir
                </p>
                <p>
                    Ensemble nous formons une équipe  une famillet et rien ne pourra nous diviser
                </p>
            </div>
            <div class="col-md-4 fade-in" id="aboutUsImageContainer2">
                <img src="../images/ab2.jpg" alt="About Us Image 2" class="img-fluid mb-4">
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-4 fade-in" id="aboutUsImageContainer3">
                <img src="../images/ab3.jpg" alt="About Us Image 3" class="img-fluid mb-4">
            </div>
            <div class="col-md-8 fade-in" id="aboutUsTextContainer3">
                <p class="lead">
                    Profiter des reductions pendant les jours de fetes et faites en profiter les membres de votre famille
                </p>
                <p>
                    Uniformes de club chaussures de sport crampons vous y trouverez absolument tout
                </p>
            </div>
        </div>
    </div>
    

    
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="..." crossorigin="anonymous"></script>
    <script src="../js/about.js"></script>
    <script>

document.addEventListener('DOMContentLoaded', function () {
    function addShowClass(elementId, delay) {
        setTimeout(function () {
            var element = document.getElementById(elementId);
            if (element) {
                element.classList.add('show');
            }
        }, delay);
    }

    addShowClass('aboutUsTitle', 50);
    addShowClass('aboutUsImageContainer1', 200);
    addShowClass('aboutUsTextContainer1', 300);
    addShowClass('aboutUsTextContainer2', 400);
    addShowClass('aboutUsImageContainer2', 500);
    addShowClass('aboutUsImageContainer3', 600);
    addShowClass('aboutUsTextContainer3', 500);
});



</script>

</body>
</html>
