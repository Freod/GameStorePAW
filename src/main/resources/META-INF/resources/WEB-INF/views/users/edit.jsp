<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../head.jsp"/>
    <title>Edit user</title>
</head>
<body>
<div id="header">
    <jsp:include page="../navbar.jsp"/>
</div>
<div class="container-lg content">
    <c:forEach items="${users}" var="user">
        <form class="form-signin" id="signupForm" method="post" action="/users/edit/${user.get().id}">
            <c:if test="${alert!=null}">
                <div class="alert alert-danger col-lg-3 col-md-4" role="alert">
                        ${alert}
                </div>
            </c:if>
            <p>
                <label for="name">First name</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="First name"
                       value="${user.get().name}" required/>
            </p>
            <p>
                <label for="surname">Last name</label>
                <input type="text" id="surname" name="surname" class="form-control" placeholder="Last name"
                       value="${user.get().surname}" required/>

            </p>
            <p>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" class="form-control" placeholder="Email"
                       value="${user.get().email}" required/>
            </p>
            <p>
                <span>Roles</span><br/>
                <input type="checkbox" name="role" value="ADMIN"
                       id="ADMIN" ${user.get().role.contains("ADMIN")?'checked':''}/>
                <label for="ADMIN">ADMIN</label><br/>
                <input type="checkbox" name="role" value="EMPLOYEE"
                       id="EMPLOYEE" ${user.get().role.contains("EMPLOYEE")?'checked':''}/>
                <label for="EMPLOYEE">EMPLOYEE</label><br/>
                <input type="checkbox" name="role" value="USER"
                       id="USER" checked disabled/>
                <label for="USER">USER</label>
            </p>
            <p>
                <span>Active</span>
                <input type="radio" id="yes" name="active" value="yes" ${user.get().active?'checked':''}/>
                <label for="yes">Yes</label>
                <input type="radio" id="no" name="active" value="no" ${!user.get().active?'checked':''}/>
                <label for="no">No</label>
            </p>
            <p><input type="submit" class="btn btn-primary mb-2" value="Save"/></p>
        </form>
    </c:forEach>
</div>
</body>
</html>