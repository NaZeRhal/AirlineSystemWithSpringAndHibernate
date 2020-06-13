<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List of Airports</title>
</head>
<body>
<h2>Airports</h2>
<table>
    <tr>
        <th>id</th>
        <th>city</th>
        <th>code</th>
    </tr>
    <c:forEach var="airport" items="${airports}">
        <tr>
            <td>${airport.id}</td>
            <td>${airport.city}</td>
            <td>${airport.airportCode}</td>
            <td>
                <a href="${pageContext.request.contextPath}/airport/edit/${airport.id}">edit</a>
                <a href="${pageContext.request.contextPath}/airport/delete/${airport.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add Airport</h2>
<c:url value="/airports/addForm" var="addForm"/>
<a href="${addForm}">Add new airport</a>
</body>
</html>
