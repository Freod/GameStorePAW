<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Services</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container content">
    <h1>Service list</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Email</th>
            <th scope="col">Package number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${repairList}" var="repair">
            <tr>
                <td>${repair.title}</td>
                <td>${repair.description}</td>
                <td>${repair.user.email}</td>
                <td>${repair.packageNumber}</td>
<%--                <td><a href="/repair/answer/${user.id}">Answer</a></td>--%>
<%--                <td><a style="color:#dc3545" href="/users/delete/${user.id}">Remove customer</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>