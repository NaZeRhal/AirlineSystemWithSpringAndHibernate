<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="crewman.list.title" var="crewmenListTitle"/>
<spring:message code="crewman.table.name" var="crewmanName"/>
<spring:message code="crewman.table.surname" var="crewmanSurname"/>
<spring:message code="crewman.table.profession" var="crewmanProfession"/>
<spring:message code="crewman.table.dateOfBirth" var="crewmanBirthDate"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>

<html>
<head>
    <title>${crewmenListTitle}</title>
</head>
<body>
<h2>${crewmenListTitle}</h2>
<table>
    <tr>
        <th>${crewmanName}</th>
        <th>${crewmanSurname}</th>
        <th>${crewmanBirthDate}</th>
        <th>${crewmanProfession}</th>
    </tr>
    <c:forEach var="crewman" items="${crewmanList}">
        <tr>
            <td>${crewman.firstName}</td>
            <td>${crewman.lastName}</td>
            <td>${crewman.dateOfBirth}</td>
            <td>${crewman.profession.name}</td>
            <td>
                <c:url value="/crewman/updateForm/${crewman.id}" var="editCrewMan"/>
                <a href="${editCrewMan}">${editButton}</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add Crewman</h2>
<c:url value="/crewman/createForm" var="createForm"/>
<a href="${createForm}">${addButton}</a>
</body>
</html>
