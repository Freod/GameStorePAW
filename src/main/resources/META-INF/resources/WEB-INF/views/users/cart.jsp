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
    <c:choose>
        <c:when test="${cart.size()>0}">
            <div class="col">
                <h2>Cart:</h2>
                <div class="col">
                    <a href="/users/cart/deleteAll" class="text-danger">Clear cart</a>
                </div>
                <div class="col">
                    <div class="table-responsive">
                        <table class="table table-bordered border-dark table-light">
                            <thead class="table-dark">
                            <tr scope="row">
                                <th scope="col">Name</th>
                                <th scope="col">Platform</th>
                                <th scope="col">Price</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${cart}" var="game">
                                <tr scope="row">
                                    <td scope="col">${game.name}</td>
                                    <td scope="col">${game.platform}</td>
                                    <td scope="col">${game.price}</td>
                                    <td scope="col"><a href="/users/cart/delete/${game.id}"
                                                       class="text-danger">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <form action="/users/cart" method="post">
                    <input type="submit" value="Pay">
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <div>
                <h1>Cart is empty</h1>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>