<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Account</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container content">
    ${user.name}
    ${user.surname}
    ${user.email}
    ${user.password}
    <p>Buyed games</p>
    <p>Services</p>
</div>
</body>
</html>