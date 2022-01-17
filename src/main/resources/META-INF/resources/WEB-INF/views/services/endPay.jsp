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
    <form action="/services/endPay/${repair.id}" method="get">
        <h1>${repair.price}</h1>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Pay</button>
        </div>
    </form>
</div>
</body>
</html>