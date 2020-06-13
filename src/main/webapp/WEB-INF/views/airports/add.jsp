<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Airport</title>
</head>
<body>
<h2>Add Airport</h2>
<form:form action="add" modelAttribute="airport">
<table>
    <tr>
<%--        <th>id</th>--%>
        <th>city</th>
        <th>code</th>
    </tr>
        <tr>
<%--            <td><form:input path="id"/></td>--%>
            <td><form:input path="city"/></td>
            <td><form:input path="airportCode"/></td>
<%--            <td>--%>
<%--                <a href="${pageContext.request.contextPath}/airport/edit/${airport.id}">edit</a>--%>
<%--                <a href="${pageContext.request.contextPath}/airport/delete/${airport.id}">delete</a>--%>
<%--            </td>--%>
        </tr>
</table>
    <input type="submit" value="Add airport">
<%--<h2>Add Airport</h2>--%>
<%--<c:url value="/airports/add" var="add"/>--%>
<%--<a href="${add}">Add new airport</a>--%>
</form:form>
</body>
</html>

