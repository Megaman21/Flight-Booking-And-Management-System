<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2017
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Footer-Clean.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Button1.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
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
                    <li role="presentation" data-bs-hover-animate="pulse"><a href="home.jsp" style="color:rgb(137,13,73);font-size:20px;">Home </a></li>

                    <li role="presentation" data-bs-hover-animate="pulse"><a href="booking.jsp" style="color:rgb(137,13,73);font-size:20px;">Book </a></li>
                    <li role="presentation" data-bs-hover-animate="pulse"><a href="about.html" style="color:rgb(137,13,73);font-size:20px;">About </a></li>
                </ul>
                <p class="navbar-text navbar-right actions" style="font-size:20px;"><a class="navbar-link login" href="signin.jsp" style="padding:30px;">Customer</a> <a class="btn btn-default action-button" role="button" href="signup.html" style="font-size:20px;background-color:#eb3b60;">Sign Out</a></p>
            </div>
        </div>
    </nav>
</div>
<div style="text-align:center;padding:40px;background:url(&quot;assets/img/plane.jpg&quot;)no-repeat;background-size:cover;">
    <div class="jumbotron" style="border-radius:20px;padding:40px;background:rgba(255,255,255,0.75);margin-top:100px;">
        <h3 style="color:rgb(238,1,1);">Invalid username or password</h3></div>
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
<script src="assets/js/myjs.js"></script>
</body>

</html>
