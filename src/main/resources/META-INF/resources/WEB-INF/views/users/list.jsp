<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Users</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <div class="table-responsive">
        <h1>Users</h1>
        <table class="table table-bordered border-dark table-light table-hover">
            <thead class="table-dark">
            <tr scope="row">
                <th scope="col">Roles</th>
                <th scope="col">Email</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Active</th>
                <th scope="col" colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr scope="row">
                    <td>${user.role}</td>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.active}</td>
                    <td><a href="/users/reset/${user.id}" class="text-primary">Password reset</a></td>
                    <td><a href="/users/edit/${user.id}" class="text-primary">Edit customer</a></td>
<%--                    <td><a href="/users/delete/${user.id}" class="text-danger">Remove customer</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>