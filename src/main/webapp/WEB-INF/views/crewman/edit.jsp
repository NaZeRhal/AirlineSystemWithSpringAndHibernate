<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:message code="crewman.add.title" var="addCrewman"/>
<spring:message code="crewman.edit.title" var="editCrewman"/>

<spring:message code="crewman.table.firstName" var="crewmanFirstName"/>
<spring:message code="crewman.table.lastName" var="crewmanLastName"/>
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
    <style type="text/css">
        <%@include file="../../styles/messages.css"%>
    </style>
</head>
<body>
<h2>${formTitle}</h2>
<form:form action="/crewman/save" modelAttribute="crewman">
    <c:if test="${not empty message}">
        <div id="message" class="${message.type}">${message.message}</div>
        <br>
    </c:if>

    <form:hidden path="id"/>

    <form:label path="firstName">${crewmanFirstName}</form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br>

    <form:label path="lastName">${crewmanLastName}</form:label>
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>

    <form:label path="dateOfBirth">${crewmanBirthDate}</form:label>
    <form:input path="dateOfBirth" placeholder="dd.MM.yyyy"/>
    <form:errors path="dateOfBirth" cssClass="error"/>
    <br>

    <form:label path="profession">${crewmanProfession}</form:label>
    <form:select path="profession.id">
        <form:options items="${professions}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:errors path="profession" cssClass="error"/>
    <br>

    <a href="/crewman/delete/${crewman.id}"${hidden}>${deleteButton}</a>
    <br>
    <br>

    <input type="submit" value="${buttonName}">
</form:form>
</body>
</html>

