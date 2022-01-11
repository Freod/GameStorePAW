<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<form:form method="post" action="/users/edit/${id}">
<%--    <p><label>Imie:</label><form:input path="name"/></p>--%>
<%--    <p><label>Nazwisko:</label><form:input path="surname"/></p>--%>
<%--    <p><label>Adres:</label><form:input path="address"/></p>--%>
    <p><input type="submit" value="Zapisz zmiany"/></p>
</form:form>
</body>