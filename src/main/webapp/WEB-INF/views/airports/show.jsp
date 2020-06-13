<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Airport</title>
</head>
<body>
<h2>Airport</h2>
<table>
    <tr>
        <th>id</th>
        <th>city</th>
        <th>code</th>
    </tr>
        <tr>
            <td>${airport.id}</td>
            <td>${airport.city}</td>
            <td>${airport.airportCode}</td>
        </tr>
</table>

<%--<h2>Add Airport</h2>--%>
<%--<c:url value="/airports/addForm" var="addForm"/>--%>
<%--<a href="${addForm}">Add new airport</a>--%>
</body>
</html>