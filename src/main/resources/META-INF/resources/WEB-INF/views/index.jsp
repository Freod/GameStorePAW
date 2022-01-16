<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="head.jsp"/>
    <title>Hello page</title>
</head>
<body>
    <div id="header">
        <jsp:include page="navbar.jsp"/>
    </div>
    <div class="container content">
        <p>login: admin password: admin</p>
        <p>login: employee password: employee</p>
        <p>login: user password: user</p>
    </div>
</body>
</html>