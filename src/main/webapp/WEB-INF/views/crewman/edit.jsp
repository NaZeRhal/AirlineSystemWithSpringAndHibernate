<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="crewman.add.title" var="addCrewman"/>
<spring:message code="crewman.edit.title" var="editCrewman"/>

<spring:message code="crewman.table.name" var="crewmanName"/>
<spring:message code="crewman.table.surname" var="crewmanSurname"/>
<spring:message code="crewman.table.profession" var="crewmanProfession"/>
<spring:message code="crewman.table.dateOfBirth" var="crewmanBirthDate"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.delete" var="deleteButton"/>

<spring:eval expression="crewman.id == null ? addCrewman : editCrewman " var="formTitle"/>
<spring:eval expression="crewman.id == null ? addButton : editButton " var="buttonName"/>
<c:if test="${crewman.id == null}">
    <c:set var="hidden" value="hidden"/>
</c:if>

<html>
<head>
    <title>${formTitle}</title>
</head>
<body>
<h2>${formTitle}</h2>
<form:form action="/crewman/save" modelAttribute="crewman">
    <table>
        <tr>
            <th>${crewmanName}</th>
            <th>${crewmanSurname}</th>
            <th>${crewmanBirthDate}</th>
            <th>${crewmanProfession}</th>
        </tr>
        <tr>
            <form:hidden path="id"/>
            <td><form:input path="firstName"/></td>
            <td><form:input path="lastName"/></td>
            <td><form:input path="dateOfBirth"/></td>
            <td>
                <form:select path="profession.id">
                    <form:options items="${professions}" itemLabel="name" itemValue="id"/>
                </form:select>
            </td>
            <td ${hidden}>
                <a href="/crewman/delete/${crewman.id}">${deleteButton}</a>
            </td>
        </tr>
    </table>
    <input type="submit" value="${buttonName}">
</form:form>
</body>
</html>

