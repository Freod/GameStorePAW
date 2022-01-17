<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Services</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <div class="table-responsive">
        <h1>Service list</h1>
        <table class="table table-bordered border-dark table-light table-hover">
            <thead class="table-dark">
            <tr scope="row">
                <th scope="col">Status</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Email</th>
                <th scope="col">Package number</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${repairList}" var="repair">
                <tr>
                    <td>${repair.status}</td>
                    <td>${repair.title}</td>
                    <td>${repair.description}</td>
                    <td>${repair.user.email}</td>
                    <td>${repair.packageNumber}</td>
                    <c:choose>
                        <c:when test="${repair.status=='Waiting'}">
                            <td><a href="/services/answer/${repair.id}">Answer</a></td>
                        </c:when>
                        <c:when test="${repair.status=='Payed'}">
                            <td><a href="/services/send/${repair.id}">Send</a></td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>