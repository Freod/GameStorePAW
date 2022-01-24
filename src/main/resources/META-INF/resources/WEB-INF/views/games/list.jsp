<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Games</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <h1>Games:</h1>
    <div class="row">
        <c:forEach items="${games}" var="game">
            <div class="col-md-6">
                <div class="row border border-dark m-2">
                    <div class="col-sm-6 p-2 text-center" style="min-height: 200px; max-height: 200px">
                        <img class="img-thumbnail" style="min-height: 180px; max-height: 180px" src="/images/${game.id}/${game.image}" alt="fileNotFound"/>
                    </div>
                    <div class="col-sm-6 p-2 text-center">
                        <p>${game.name}</p>
                        <p>${game.platform}</p>
                        <p>${game.price}</p>
                        <p><a href="/users/addToCart/${game.id}">Add to cart</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>