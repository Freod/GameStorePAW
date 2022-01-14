<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Games</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container content">
    <h1>Games:</h1>
    <ul class="productList row grid">
        <li class="ajax_block_product col-md-3 last-item-of-tablet-line col-xs-12 col-sm-6 col-md-4">
            <div class="product">
                <c:forEach items="${games}" var="game">
                    <p>${game.name}</p>
                    <p>${game.platform}</p>
                    <p>${game.price}</p>
                    <p><a href="/games/addToCart/${game.id}">Add to cart</a></p>
                </c:forEach>
            </div>
        </li>
    </ul>

</div>
</body>
</html>