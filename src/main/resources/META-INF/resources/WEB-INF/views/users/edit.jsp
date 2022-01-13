<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head></head>
<body>
<c:forEach items="${users}" var="user">
<%--    ${user}--%>
<form class="form-signin" id="signupForm" method="post" action="/users/edit/${user.get().id}">
<%--<form class="form-signin" id="signupForm" method="post" action="/users/edit">--%>
    <p>
        <label for="name" class="sr-only">First name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="First name" value="${user.get().name}" required/>
    </p>
    <p>
        <label for="surname" class="sr-only">Last name</label>
        <input type="text" id="surname" name="surname" class="form-control" placeholder="Last name" value="${user.get().surname}" required/>

    </p>
    <p>
        <label for="email" class="sr-only">Email</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Email" value="${user.get().email}" required/>
    </p>
    <%--        ${user.name}--%>

    <%--    <p><label>Nazwisko:</label><form:input path="surname"/></p>--%>
    <%--    <p><label>Adres:</label><form:input path="address"/></p>--%>
    <p>
        ${user.get().role}
        <span class="sr-only">Roles</span><br/>
        <input type="checkbox" name="role" value="ADMIN" id="ADMIN"/>
        <label for="ADMIN" class="sr-only">ADMIN</label><br/>
        <input type="checkbox" name="role" value="EMPLOYEE" id="EMPLOYEE"/>
        <label for="EMPLOYEE" class="sr-only">EMPLOYEE</label><br/>
        <input type="checkbox" name="role" value="USER" id="USER"/>
        <label for="USER" class="sr-only">USER</label>
    </p>
    <p>
        <span class="sr-only">Active</span>
        <input type="radio" id="yes" name="active" value="yes" ${user.get().active?'checked':''}/>
        <label for="yes" class="sr-only">Yes</label>
        <input type="radio" id="no" name="active" value="no" ${!user.get().active?'checked':''}/>
        <label for="no" class="sr-only">No</label>
    </p>
    <p><input type="submit" value="Save"/></p>
</form>
</c:forEach>
</body>
</html>