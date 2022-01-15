<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Sell game</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <form method="post" action="/games/sell">
        <h1>Sell game</h1>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Name" required>
        </div>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="platform">Platform</label>
            <input type="text" id="platform" name="platform" class="form-control" placeholder="Platform" required>
        </div>
        <div class="col-lg-3 col-md-4  p-2">
            <label for="price">Price</label>
            <input type="text" id="price" name="price" class="form-control" placeholder="Price" required>
        </div>
        <div>
            images
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Sell</button>
        </div>
    </form>
</div>
</body>
</html>