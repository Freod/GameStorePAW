<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Orders</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <h2>Orders:</h2>
    <div class="table-responsive">
        <table class="table table-bordered border-dark table-light">
            <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Email</th>
                <th>Status</th>
                <th>Name</th>
                <th>Platform</th>
                <th>Price</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <c:forEach items="${order.games}" var="game" varStatus="status">
                    <tr scope="row">
                        <c:choose>
                            <c:when test="${status.first}">
                                <td rowspan="${order.games.size()}">${order.id}</td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${status.first}">
                                <td rowspan="${order.games.size()}">${order.user.email}</td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${status.first}">
                                <td rowspan="${order.games.size()}">${order.status}</td>
                            </c:when>
                        </c:choose>
                        <td>${game.name}</td>
                        <td>${game.platform}</td>
                        <td>${game.price}</td>
                        <c:choose>
                            <c:when test="${status.first}">
                                <td rowspan="${order.games.size()}"><p><a href="/orders/send/${order.id}">Send</a></p></td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${status.first}">
                                <td rowspan="${order.games.size()}"><p><a class="text-danger" href="/orders/delete/${order.id}">Delete</a></p></td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>