<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Repair answer</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <form method="get" action="/services/answer/update/${repair.id}">
        <c:if test="${alert!=null}">
            <div class="alert alert-danger col-lg-3 col-md-4" role="alert">
                    ${alert}
            </div>
        </c:if>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="price">Price</label>
            <input type="number" id="price" name="price" class="form-control" placeholder="Price" maxlength="4" min="0" max="999999" required autofocus>
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Update</button>
        </div>
    </form>
</div>
</body>
</html>