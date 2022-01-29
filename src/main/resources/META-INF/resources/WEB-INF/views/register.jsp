<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="head.jsp"/>
    <title>Please sign up</title>
    <script>
        function showPassword(){
            document.getElementById("password").type="text";
        }
        function hidePassword(){
            document.getElementById("password").type="password";
        }
    </script>
</head>
<body>
<div id="header">
    <jsp:include page="navbar.jsp"/>
</div>
<div class="container">
    <form class="form-signin" id="signupForm" method="post" action="/register">
        <h2 class="form-signup-heading">Please sign up</h2>
        <c:if test="${alert!=null}">
            <div class="alert alert-danger col-lg-3 col-md-4" role="alert">
                    ${alert}
            </div>
        </c:if>
        <p>
            <label for="name">First name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="First name" value="${user.name}" required
                   autofocus>
        </p>
        <p>
            <label for="surname">Last name</label>
            <input type="text" id="surname" name="surname" class="form-control" placeholder="Last name" value="${user.surname}" required>
        </p>
        <p>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Email" value="${user.email}" required>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            <input type="button" onmousedown="showPassword()" onmouseup="hidePassword()" value="Show Password"/>
        </p>
        <button class="btn btn-lg btn-primary btn-block" id="btnSubmit" type="submit">Sign up</button>
    </form>
</div>
</body>
</html>