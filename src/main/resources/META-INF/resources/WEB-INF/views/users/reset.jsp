<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Password reset</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <form class="form-signin" id="signupForm" method="post" action="/users/reset/${user.get().id}">
        <c:if test="${alert!=null}">
            <div class="alert alert-danger col-lg-3 col-md-4" role="alert">
                    ${alert}
            </div>
        </c:if>
        <div class="col-lg-3 col-md-4 p-2">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required
                   autofocus/>
        </div>
        <div class="p-2">
            <button class="btn btn-md btn-dark btn-block" id="btnSubmit" type="submit">Change</button>
        </div>
    </form>
</div>
</body>
</html>