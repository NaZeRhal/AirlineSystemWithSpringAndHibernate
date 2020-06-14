<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="crewman.list.title" var="crewmenListTitle"/>
<spring:message code="crewman.table.name" var="crewManName"/>
<spring:message code="crewman.table.surname" var="crewManSurname"/>
<spring:message code="crewman.table.profession" var="crewManProfession"/>
<spring:message code="crewman.table.dateOfBirth" var="crewManBirthDate"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>

<c:if test="${crewman.id == null}">
    <c:set var="hidden" value="hidden"/>
</c:if>

<html>
<head>
    <title>${crewmenListTitle}</title>
</head>
<body>
<h2>${crewmenListTitle}</h2>
<table>
    <tr>
        <th>${crewManName}</th>
        <th>${crewManSurname}</th>
        <th>${crewManBirthDate}</th>
        <th>${crewManProfession}</th>
    </tr>
    <c:forEach var="crewman" items="${crewmanList}">
        <tr>
            <td>${crewman.firstName}</td>
            <td>${crewman.lastName}</td>
            <td>${crewman.dateOfBirth}</td>
            <td>${crewman.profession.name}</td>
            <td ${hidden}>
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
