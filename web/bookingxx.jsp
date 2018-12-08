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
                        <li class="active" role="presentation" data-bs-hover-animate="pulse"><a href="booking.jsp" style="color:rgb(137,13,73);font-size:20px;">Book </a></li>
                        <li role="presentation" data-bs-hover-animate="pulse"><a href="about.html" style="color:rgb(137,13,73);font-size:20px;">About </a></li>
                    </ul>
                    <p class="navbar-text navbar-right actions" style="font-size:20px;"><a class="navbar-link login" href="signin.html" style="padding:30px;">Log In</a> <a class="btn btn-default action-button" role="button" href="signup.html" style="font-size:20px;background-color:#eb3b60;">Sign Up</a></p>
                </div>
            </div>
        </nav>
    </div>
    <div style="text-align:center;padding:40px;background:url(&quot;assets/img/plane.jpg&quot;)no-repeat;background-size:cover;">
        <div class="jumbotron" style="border-radius:20px;padding:40px;background:rgba(255,255,255,0.75);margin-top:100px;">
            <form method="post" action="/searchresults">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">From </label>
                            <input class="form-control" name="from" type="text" style="width:270px;margin:auto;">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">To </label>
                            <input class="form-control" name="to" type="text" style="width:270px;margin:auto;">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label">Date</label>
                    <input class="form-control" type="date" onchange="setMinDate()" id="departuredate" name="date" style="width:150px;height:30px;margin:auto;">
                </div>

                <div class="form-group">
                    <select name="class">
                        <option value="economy">Economy</option>
                        <option value="firstclass">First Class</option>
                        <option value="business">Business Class</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label">Seats </label>
                    <input class="form-control" name="seats" type="number" min="1" style="width:70px;margin:auto;">
                </div>

                <button class="btn btn-default" type="submit" style="margin-top:20px;width:243px;"><strong>Search Flights</strong></button>
            </form>
        </div>
    </div>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="assets/js/easyResponsiveTabs.js"></script>
    <script src="assets/js/myscript.js"></script>
</body>

</html>