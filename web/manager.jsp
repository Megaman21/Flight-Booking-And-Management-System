<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <nav class="navbar navbar-default navigation-clean-button" style="background-color:#ffc107;">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">Shojo Airlines</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-left">
                    <li role="presentation" data-bs-hover-animate="pulse"><a href="home.jsp" style="color:rgb(137,13,73);font-size:20px;">Home </a></li>

                    <li role="presentation" data-bs-hover-animate="pulse"><a href="about.jsp" style="color:rgb(137,13,73);font-size:20px;">About </a></li>
                </ul>
                <p class="navbar-text navbar-right actions" style="font-size:20px;"><a class="navbar-link login" style="padding:30px;">Manager </a> <a class="btn btn-default action-button" role="button" href="/signout" style="font-size:20px;background-color:#eb3b60;">Sign Out</a></p>
            </div>
        </div>
    </nav>
    <div style="text-align:center;padding:40px;background:url(&quot;plane.jpg&quot;)no-repeat;background-size:cover;">
        <div class="jumbotron" style="border-radius:20px;padding:40px;background:rgba(255,255,255,0.75);margin-top:100px;text-align:center;position:relative;">
            <form method="post" action="<%=response.encodeURL(request.getContextPath()+"/managerhomepage")%>">
            <div class="table-responsive table-bordered table-hover row-clickable" style="text-align:center;position:relative;">
                <table class="table">
                    <thead style="text-align:center;">
                        <tr>
                            <th style="text-align:center;">Flight No.</th>
                            <th style="text-align:center;">Total Seats</th>
                            <th style="text-align:center;">Economy Seats</th>
                            <th style="text-align:center;"><strong>Price </strong></th>
                            <th style="text-align:center;"><strong>First Class Seats</strong></th>
                            <th style="text-align:center;"><strong>Price</strong></th>
                            <th style="text-align:center;"><strong>Business Seats</strong></th>
                            <th style="text-align:center;"><strong>Price </strong></th>
                            <th style="text-align:center;">Status </th>
                        </tr>
                    </thead>
                    <tbody>
                    <%--<jsp:useBean id="flights_list" scope="request" type="java.util.List"/>--%>
                    <% ArrayList flights_list = (ArrayList)request.getAttribute("flights_list");%>
                        <c:forEach items="${flights_list}" var="manager_flights">

                    <tr>
                        <td>
                            <h4 id="flight_name">${manager_flights.flight_name}</h4></td>
                        <td>
                            <h5 id="total_seats">${manager_flights.total_seats}</h5></td>
                        <td>
                            <h6 id="economyseats">${manager_flights.economy_seats}</h6></td>
                        <td>
                            <h7 id="economyprice">${manager_flights.economy_price}</h7></td>
                        <td>
                            <h8 id="firstclass_seats">${manager_flights.firstclass_seats}</h8></td>
                        <td>
                            <h9 id="firstclass_price">${manager_flights.firstclass_price}</h9></td>
                        <td>
                            <h10 id="business_seats">${manager_flights.business_seats}</h10></td>
                        <td>
                            <h11 id="business_price">${manager_flights.business_price}</h11></td>
                        <td>
                            <%--<div class="dropdown">--%>
                                <%--<button class="btn btn-default dropdown-toggle"  data-toggle="dropdown" aria-expanded="false" type="button" style="width:90px;">Pending<span class="caret"></span></button>--%>
                                <%--<ul id="test" class="dropdown-menu"  role="menu">--%>
                                    <%--<li role="presentation"><a href="#">Approve </a></li>--%>
                                    <%--<li role="presentation"><a href="#">Reject </a></li>--%>
                                <%--</ul>--%>
                            <%--</div>--%>
                                <select id="status" name=${manager_flights.id}>
                                    <option value="Accept">Accept</option>
                                    <option value="Reject">Reject</option>

                                </select>
                        </td>
                    </tr>



                    </c:forEach>
                       <%-- <tr>
                            <td>PK-653 </td>
                            <td>85 </td>
                            <td>25 </td>
                            <td>9000 </td>
                            <td>30 </td>
                            <td>12000 </td>
                            <td>30 </td>
                            <td>15000 </td>
                            <td>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button">Pending <span class="caret"></span></button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li role="presentation"><a href="#">Approve </a></li>
                                        <li role="presentation"><a href="#">Reject </a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>PK-458 </td>
                            <td>90 </td>
                            <td>30 </td>
                            <td>95000 </td>
                            <td>30 </td>
                            <td>12500 </td>
                            <td>30 </td>
                            <td>15000 </td>
                            <td>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="width:90px;">Pending<span class="caret"></span></button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li role="presentation"><a href="#">Approve </a></li>
                                        <li role="presentation"><a href="#">Reject </a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>--%>
                    </tbody>
                </table>
            </div>
            <button class="btn btn-default" type="submit" style="margin-top:20px;"><strong>Save Changes</strong></button>
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
    <script src="assets/js/easyResponsiveTabs.js"></script>
    <script src="assets/js/myscript.js"></script>
</body>

</html>