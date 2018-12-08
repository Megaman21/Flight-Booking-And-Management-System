<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WebProject</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Button1.css">
    <link rel="stylesheet" href="assets/css/Pretty-Footer.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
    <div>
        <nav class="navbar navbar-default navigation-clean-button" style="background-color:#ffc107;">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">Shojo Airlines</a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" data-bs-hover-animate="pulse"><a href="home.html" style="color:rgb(137,13,73);font-size:20px;">Home </a></li>
                        <li role="presentation" data-bs-hover-animate="pulse"><a href="booking.jsp" style="color:rgb(137,13,73);font-size:20px;">Book </a></li>
                        <li role="presentation" data-bs-hover-animate="pulse"><a href="about.html" style="color:rgb(137,13,73);font-size:20px;">About </a></li>
                    </ul>
                    <p class="navbar-text navbar-right actions" style="font-size:20px;"><a class="navbar-link login" href="/LogInServlet" style="padding:30px;">Log In</a> <a class="btn btn-default action-button" role="button" href="signup.html" style="font-size:20px;background-color:#eb3b60;">Sign Up</a></p>
                </div>
            </div>
        </nav>
    </div>
    <div class="carousel slide" data-ride="carousel" data-interval="1500" id="carousel-1" style="width:950px;/*align-self:center;*/margin-left:auto;margin-right:auto;">
        <div class="carousel-inner" role="listbox">
            <div class="item active"><img class="img-responsive" src="assets/img/6835595-paris-tourist-attractions.jpg" alt="Slide Image" style="width:1000px;height:450px;">
                <div class="carousel-caption">
                    <p style="font-size:20px;">Explore the World!</p>
                </div>
            </div>
            <div class="item"><img class="img-responsive" src="assets/img/10-13-things-your-flight-attendant-wont-tell-you-tattling.jpg" alt="Slide Image" style="width:1000px;height:450px;"></div>
            <div class="item"><img class="img-responsive" src="assets/img/13.jpg" alt="Slide Image" style="width:950px;height:450px;">
                <div class="carousel-caption">
                    <h3 style="font-family:'Open Sans', sans-serif;color:rgb(231,41,75);font-size:34px;">Time Flies</h3>
                    <p style="font-size:20px;color:rgb(235,35,119);">Watch hundreds of free TV shows and movies on your flight</p>
                </div>
            </div>
        </div>
        <div><a class="left carousel-control" href="#carousel-1" role="button" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i><span class="sr-only">Previous</span></a>
            <a class="right carousel-control" href="#carousel-1" role="button" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i><span class="sr-only">Next</span></a>
        </div>
        <ol class="carousel-indicators">
            <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-1" data-slide-to="1"></li>
            <li data-target="#carousel-1" data-slide-to="2"></li>
        </ol>
    </div>
    <footer style="height:180px;margin-top:10px;background-color:rgb(255,165,0);">
        <div class="row">
            <div class="col-md-4 col-sm-6 footer-navigation">
                <h3><a href="#" style="color:#1f2021;">Shojo Airlines</a></h3>
                <p class="company-name" style="color:#1f2021;">Shojo Airlines© 1985</p>
            </div>
            <div class="col-md-4 col-sm-6 footer-contacts">
                <div><span class="fa fa-map-marker footer-contacts-icon"> </span>
                    <p style="color:#1f2021;"><span class="new-line-span">21 Milaad Street</span> Lahore, Pakistan</p>
                </div>
                <div><i class="fa fa-phone footer-contacts-icon"></i>
                    <p class="footer-center-info email text-left" style="color:#1f2021;"> +1 555 123456</p>
                </div>
                <div><i class="fa fa-envelope footer-contacts-icon"></i>
                    <p style="color:#1f2021;"> support@shojo.com</p>
                </div>
            </div>
            <div class="clearfix visible-sm-block"></div>
            <div class="col-md-4 footer-about">
                <h4 style="color:#1f2021;">About the company</h4>
                <p style="color:#1f2021;"> Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce euismod convallis velit, eu auctor lacus vehicula sit amet.
                </p>
                <div class="social-links social-icons"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-github"></i></a></div>
            </div>
        </div>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="assets/js/easyResponsiveTabs.js"></script>
    <script src="assets/js/myscript.js"></script>
</body>

</html>