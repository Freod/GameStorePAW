<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="/">GameStore</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <sec:authorize url="/games/list">
                <li class="nav-item">
                    <a class="nav-link" href="/games/list">Games</a>
                </li>
            </sec:authorize>
            <sec:authorize url="/games/sell">
                <li>
                    <a class="nav-link" href="/games/sell">Sell game</a>
                </li>
            </sec:authorize>
            <sec:authorize url="/services/add">
                <li>
                    <a class="nav-link" href="/services/add">Repair service</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasAnyAuthority('EMPLOYEE', 'ADMIN')">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Employee
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/games/add">Add game</a>
                        <a class="dropdown-item" href="/services/list">Services</a>
                    </div>
                </li>
            </sec:authorize>
            <sec:authorize url="/users/list">
                <li class="nav-item">
                    <a class="nav-link" href="/users/list">Manage users</a>
                </li>
            </sec:authorize>
            <sec:authorize url="/users/account">
                <li class="nav-item">
                    <a class="nav-link" href="/payment/cart">Cart</a>
                </li>
            </sec:authorize>
            <sec:authorize url="/payment/cart">
                <li class="nav-item">
                    <a class="nav-link" href="/payment/cart">Cart</a>
                </li>
            </sec:authorize>
            <sec:authorize url="/users/account">
                <li class="nav-item">
                    <a class="nav-link" href="/users/account">Account</a>
                </li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/login">Sign in</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>
