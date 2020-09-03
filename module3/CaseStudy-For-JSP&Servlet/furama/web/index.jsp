<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/2/2020
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/font/css/all.css">
    <title>Furama Resort</title>
</head>
<body>


<header>
    <div class="row container-fluid">
        <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4" style="float:left">Furama</div>
        <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4" style="float:right">NGUYEN VAN A</div>
    </div>
</header>


<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
<%--        <p class="navbar-brand" href="#">logo</p>--%>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>
        </div>

        <div class="input-group">
            <span class="input-group-btn">
                <button class="btn btn-success" type="button">Search</button>
            </span>
            <input type="text" class="form-control" placeholder="search for...">
        </div>

    </div>
</nav>


<div class="row container-fluid padding">
    <div class="col-12 col-sm-3 col-md-3 col-lg-3">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="#">Item One</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Item Two</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Item Three</a></li>
        </ul>
    </div>
    <div class="col-12 col-sm-9 col-md-9 col-lg-9">

        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
                <li data-target="#slides" data-slide-to="3"></li>
            </ul>

            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

    </div>
</div>
<br>
<hr class="my-4">


<footer>
    <div class="container-fluid padding">
        <div class="row text-center col-12">
            <p>FOOTER</p>
        </div>
    </div>
</footer>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>