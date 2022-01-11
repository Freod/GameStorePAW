<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello page</title>
</head>
<body>
    <div id="header">
        <jsp:include page="navbar.jsp"/>
    </div>
    <h1>Hello there <%= LocalTime.now()%></h1>
</body>
</html>
