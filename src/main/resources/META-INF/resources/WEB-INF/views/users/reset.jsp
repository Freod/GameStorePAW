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
        <p>
            <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required autofocus/>
        </p>
        <p><input type="submit" class="btn btn-primary mb-2" value="Save"/></p>
    </form>
</div>
</body>
</html>