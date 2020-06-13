<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="airports.list.title" var="airportListTitle"/>
<spring:message code="airports.table.city" var="airportCity"/>
<spring:message code="airports.table.code" var="airportCode"/>
<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>


<html>
<head>
    <title>${airportListTitle}</title>
</head>
<body>
<h2>${airportListTitle}</h2>
<table>
    <tr>
<%--        <th>ID</th>--%>
        <th>${airportCity}</th>
        <th>${airportCode}</th>
    </tr>
    <c:forEach var="airport" items="${airports}">
        <tr>
<%--            <td>${airport.id}</td>--%>
            <td>${airport.city}</td>
            <td>${airport.airportCode}</td>
            <td>
                <c:url value="/airports/updateForm/${airport.id}" var="editAirport"/>
                <a href="${editAirport}">${editButton}</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add Airport</h2>
<c:url value="/airports/createForm?new" var="createForm"/>
<a href="${createForm}">${addButton}</a>
</body>
</html>
