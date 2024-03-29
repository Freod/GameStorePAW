<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${alert!=null}">
            <div class="alert alert-danger col-lg-3 col-md-4" role="alert">
                    ${alert}
            </div>
        </c:if>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" class="form-control" placeholder="Title" maxlength="255" value="${repair.title}"required>
        </div>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" placeholder="Description" maxlength="255" required>${repair.description}</textarea>
        </div>
        <div class="col-lg-3 col-md-4  p-2">
            <label for="packageNumber">Package number</label>
            <input type="number" id="packageNumber" name="packageNumber" class="form-control" placeholder="Package number" minlength="5" maxlength="30" min="0" value="${repair.packageNumber}" required>
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Send</button>
        </div>
    </form>
</div>
</body>
</html>