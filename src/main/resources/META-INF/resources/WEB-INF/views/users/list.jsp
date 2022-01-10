<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello page</title>
</head>
<body>
<h1>Users list</h1>
<c:forEach items="${users}" var="user">
    <div>
            ${user.role} ${user.email} ${user.name} ${user.surname} ${user.active}
<%--        <a href="/edit-customer/${customer.id}">Edit customer</a>--%>
<%--        <a href="/remove-customer/${customer.id}">Remove customer</a>--%>
    </div>
</c:forEach>
</body>
</html>