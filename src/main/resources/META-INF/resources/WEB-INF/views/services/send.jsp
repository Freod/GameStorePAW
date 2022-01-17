<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Order sending</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <form method="get" action="/services/endSend/${repair.id}">
        <div class="col-lg-3 col-md-4 p-2">
            <label for="packageNumber">Package number</label>
            <input type="number" id="packageNumber" name="packageNumber" class="form-control" placeholder="Package number" required autofocus>
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Send</button>
        </div>
    </form>
</div>
</body>
</html>