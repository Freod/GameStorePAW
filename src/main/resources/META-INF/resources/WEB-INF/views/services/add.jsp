<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Add service</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <form method="post" action="/services/add">
        <h1>Add service</h1>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" class="form-control" placeholder="Title" required>
        </div>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="description">Description</label>
            <input type="text" id="description" name="description" class="form-control" placeholder="Description" required>
        </div>
        <div class="col-lg-3 col-md-4  p-2">
            <label for="packageNumber">Package number</label>
            <input type="text" id="packageNumber" name="packageNumber" class="form-control" placeholder="Package number" required>
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Sell</button>
        </div>
    </form>
</div>
</body>
</html>