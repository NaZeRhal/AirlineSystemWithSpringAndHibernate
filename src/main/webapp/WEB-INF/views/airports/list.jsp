<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<spring:message code="airports.list.title" var="airportListTitle"/>
<spring:message code="airports.table.city" var="airportCity"/>
<spring:message code="airports.table.code" var="airportCode"/>
<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.home" var="homeButton"/>


<html>
<head>
    <title>${airportListTitle}</title>
    <style type="text/css">
        <%@include file="../../styles/messages.css"%>
    </style>
</head>
<body>
<h2>${airportListTitle}</h2>
<c:if test="${not empty message}">
    <div id="message" class="${message.type}">${message.message}</div>
    <br>
</c:if>
<table>
    <tr>
        <th>${airportCity}</th>
        <th>${airportCode}</th>
    </tr>
    <c:forEach var="airport" items="${airports}">
        <tr>
            <td>${airport.city}</td>
            <td>${airport.airportCode}</td>
            <td>
                <c:url value="/airports/updateForm/${airport.id}" var="editAirport"/>
                <a href="${editAirport}">${editButton}</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/airports/createForm" var="createForm"/>
<c:url value="/" var="homeUrl"/>
<h3><a href="${createForm}">${addButton}</a></h3>
<h3><a href="${homeUrl}">${homeButton}</a></h3>

</body>
</html>
