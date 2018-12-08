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
                        <li role="presentation" data-bs-hover-animate="pulse"><a href="booking.html" style="color:rgb(137,13,73);font-size:20px;">Book </a></li>
                        <li role="presentation" data-bs-hover-animate="pulse"><a href="about.html" style="color:rgb(137,13,73);font-size:20px;">About </a></li>
                    </ul>
                    <p class="navbar-text navbar-right actions" style="font-size:20px;"><a class="navbar-link login" href="signin.html" style="padding:30px;">Log In</a> <a class="btn btn-default action-button" role="button" href="signup.html" style="font-size:20px;background-color:#eb3b60;">Sign Up</a></p>
                </div>
            </div>
        </nav>
    </div>
    <div class="register-photo" style="background-color:#f2f5f8;">
        <div class="form-container">
            <div class="image-holder" style="background-image:url(&quot;assets/img/open-office-concept-hawaiian-airlines-corporate-office.jpg&quot;);"></div>
            <form method="post" action="<%=response.encodeURL(request.getContextPath()+"/SignUpServlet")%>">
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <input class="form-control"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"  type="password" name="password" placeholder="Password"onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '');if(this.checkValidity()) form.password_repeat.pattern = this.value;" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password_repeat" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" placeholder="Password (repeat)" required>
                </div>
                <div class="form-group"></div>
                <div class="radio">
                    <label>
                        <input type="radio" name="type"value="admin"><strong>Admin</strong></label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="type"value="manager"><strong>Manager</strong></label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="type"value="customer"><strong>Customer</strong></label>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit" style="margin:20px 0px 0px;">Sign Up</button>
                </div><a href="signin.html" class="already">You already have an account? Login here.</a></form>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="assets/js/easyResponsiveTabs.js"></script>
    <script src="assets/js/myscript.js"></script>
</body>

</html>