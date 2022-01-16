<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Account</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <div class="row">
        <div class="col-lg-3">
            <h2>Account details:</h2>
            <p>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-envelope" viewBox="0 0 16 16">
                    <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
                </svg>
                ${user.email}
            </p>
            <p>
                First name:
                ${user.name}
            </p>
            <p>
                Last name:
                ${user.surname}
            </p>
        </div>
        <div class="col">
            <h2>Orders:</h2>
            <div class="table-responsive">
                <table class="table table-bordered border-dark table-light">
                    <thead class="table-dark">
                    <tr scope="row">
                        <th scope="col">#</th>
                        <th scope="col">Status</th>
                        <th scope="col">Name</th>
                        <th scope="col">Platform</th>
                        <th scope="col">Price</th>
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
                                        <td rowspan="${order.games.size()}">Status</td>
                                    </c:when>
                                </c:choose>
                                <td>${game.name}</td>
                                <td>${game.platform}</td>
                                <td>${game.price}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <h2>Services:</h2>
            <div class="table-responsive">
                <table class="table table-bordered border-dark table-light">
                    <thead class="table-dark">
                    <tr scope="row">
                        <th scope="col">#</th>
                        <th scope="col">Status</th>
                        <th scope="col">Title</th>
                        <th scope="col">Desciption</th>
                        <th scope="col">Package</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${repairs}" var="repair">
                        <tr scope="row">
                            <td>${repair.id}</td>
                            <td>Status</td>
                            <td>${repair.title}</td>
                            <td>${repair.description}</td>
                            <td>${repair.packageNumber}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>