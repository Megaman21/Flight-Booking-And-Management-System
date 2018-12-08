<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>homepage</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Footer-Clean.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Button1.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-default navigation-clean-button" style="background-color:#ffc107;">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">Shojo Airlines</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-left">
                    <li role="presentation" data-bs-hover-animate="pulse"><a href="home.jsp" style="color:rgb(137,13,73);font-size:20px;">Home </a></li>


                    <li role="presentation" data-bs-hover-animate="pulse"><a href="/updatepage" style="color:rgb(137,13,73);font-size:20px;">Update Flight </a></li>
                    <li role="presentation" data-bs-hover-animate="pulse"><a href="about.html" style="color:rgb(137,13,73);font-size:20px;">About </a></li>
                </ul>
                <p class="navbar-text navbar-right actions" style="font-size:20px;"><a class="navbar-link login" style="padding:30px;">Admin </a> <a class="btn btn-default action-button" role="button" href="/signout" style="font-size:20px;background-color:#eb3b60;">Sign Out</a></p>
            </div>
        </div>
    </nav>
    <div style="text-align:center;padding:40px;background:url(&quot;assets/img/plane.jpg&quot;)no-repeat;background-size:cover;">
        <div class="jumbotron" style="border-radius:20px;padding:40px;background:rgba(255,255,255,0.75);margin-top:20px;">
            <form method="post" id="form" onsubmit="return validateForm()"  action="<%=response.encodeURL(request.getContextPath()+"/AddFlightServlet")%>">
                <div class="form-group">
                    <label class="control-label">Flight Number</label>
                    <input class="form-control" type="text" required name="flight no." style="width:270px;margin:auto;">
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">From </label>
                            <input class="form-control" type="text" required name="from" style="width:270px;margin:auto;">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">To </label>
                            <input class="form-control" type="text" required name="to" style="width:270px;margin:auto;">
                        </div>
                    </div>
                </div>
                <%--<div class="row" style="margin-top:20px;">--%>
                    <%--<div class="col-md-6">--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="control-label">Departure Date </label>--%>
                            <%--<input class="form-control" type="date" id="date" required name="departure date" style="width:100px;height:30px;margin:auto;">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-6">--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="control-label">Return Date </label>--%>
                            <%--<input class="form-control" type="date" required name="arrival date" style="width:100px;height:30px;margin:auto;">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label class="control-label">Date</label>
                    <input class="form-control" type="date" onchange="setMinDate()" id="date" required name="departure date" style="width:150px;height:30px;margin:auto;">
                </div>
                <div class="form-group">
                    <label class="control-label">Total Seats</label>
                    <input class="form-control" id="totalseats" required type="number" min="0" name="total" style="width:60px;height:30px;margin:auto;">
                </div>
                <div class="row" style="margin-top:20px;">
                    <div class="col-md-4" style="outline:solid;outline-color:#4f86c3;">
                        <div class="form-group">
                            <label class="control-label">Economy Class Seats</label>
                            <input class="form-control" min="0" required id="economyseats" type="number" name="economy seats" style="width:60px;height:30px;margin:auto;">
                        </div>
                        <div class="form-group">
                            <label class="control-label">Economy Class Price</label>
                            <input class="form-control" type="number" required name="economy price" style="width:60px;height:30px;margin:auto;">
                        </div>
                    </div>
                    <div class="col-md-4" style="outline:solid;outline-color:#4f86c3;">
                        <div class="form-group">
                            <label class="control-label">First Class Seats</label>
                            <input class="form-control" type="number"min="0" id="firstclassseats" required name="first seats" style="width:60px;height:30px;margin:auto;">
                        </div>
                        <div class="form-group">
                            <label class="control-label">First Class Price</label>
                            <input class="form-control" type="number" required name="first price" style="width:60px;height:30px;margin:auto;">
                        </div>
                    </div>
                    <div class="col-md-4" style="outline:solid;outline-color:#4f86c3;">
                        <div class="form-group">
                            <label class="control-label">Business Class Seats</label>
                            <input class="form-control" type="number" required min="0" id="businessseats" name="business seats" style="width:60px;height:30px;margin:auto;">
                        </div>
                        <div class="form-group">
                            <label class="control-label">Business Class Price</label>
                            <input class="form-control" type="number" required name="business price" style="width:60px;height:30px;margin:auto;">
                        </div>
                    </div>
                </div>
                <button class="btn btn-default" type="submit" style="margin-top:40px;"><strong>Add Flight</strong></button>
            </form>
        </div>
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

    <script type="text/javascript" src="assets/js/myscript.js"></script>
    <script>

        function validateForm() {
            var economy = document.getElementById("economyseats").value;
            var business = document.getElementById("businessseats").value;
            var firstclass = document.getElementById("firstclassseats").value;
            var total = Number(document.getElementById("totalseats").value);
            var totalseats=Number(economy)+Number(business)+Number(firstclass);
            console.log(total);
            console.log(totalseats);
            if (total!=totalseats) {
                document.getElementById("totalseats").focus();
                alert("Total Seats must match the sum of seats of all classes ");
                return false;
            }
            return true;
        }
    </script>
    <script>
        var t=new Date();
        t.setDate(t.getDate()+2);
        var today = new Date(t).toISOString().split('T')[0];
        document.getElementById("date").setAttribute('min', today);

    </script>

</body>

</html>