<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="airports.add.title" var="addAirport"/>
<spring:message code="airports.edit.title" var="editAirport"/>
<spring:message code="airports.table.city" var="airportCity"/>
<spring:message code="airports.table.code" var="airportCode"/>
<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.delete" var="deleteButton"/>

<spring:eval expression="airport.id == null ? addAirport : editAirport " var="formTitle"/>
<spring:eval expression="airport.id == null ? addButton : editButton " var="buttonName"/>

<html>
<head>
    <title>${formTitle}</title>
</head>
<body>
<h2>${formTitle}</h2>
<form:form action="/airports/save" modelAttribute="airport">
    <table>
        <tr>
            <th>${airportCity}</th>
            <th>${airportCode}</th>
        </tr>
        <tr>
            <td><form:input path="city"/></td>
            <td><form:input path="airportCode"/></td>
<%--            <td><a href="/airport/delete/${airport.id}">${deleteButton}</a></td>--%>
        </tr>
    </table>
    <input type="submit" value="${buttonName}">
</form:form>
</body>
</html>

