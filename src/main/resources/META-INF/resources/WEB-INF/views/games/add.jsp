<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Add game</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <form method="post" action="/games/add" enctype="multipart/form-data">
        <h1>Add game</h1>
        <c:if test="${alert!=null}">
            <div class="alert alert-danger col-lg-3 col-md-4" role="alert">
                ${alert}
            </div>
        </c:if>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Name" value="${game.name}" maxlength="255" required>
        </div>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="platforms">Platform</label>
            <select name="platform" id="platforms">
                <c:forEach items="${platforms}" var="platform">
                <option value="${platform.toString()}">${platform.toString()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-3 col-md-4  p-2">
            <label for="price">Price</label>
            <input type="number" id="price" name="price" class="form-control" placeholder="Price" value="${game.price}" min="1" max="999999" min="0" required>
        </div>
        <div class="col-lg-3 col-md-4  p-2">
            <label for="file">Photos: </label>
            <input type="file" id="file" name="file" accept="image/png, image/jpeg" />
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Add</button>
        </div>
    </form>
</div>
</body>
</html>