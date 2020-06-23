<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:message code="user.add.title" var="addUser"/>
<spring:message code="user.edit.title" var="editUser"/>

<spring:message code="user.table.firstName" var="userFirstName"/>
<spring:message code="user.table.lastName" var="userLastName"/>
<spring:message code="user.table.userType" var="userUserType"/>
<spring:message code="user.table.login" var="userLogin"/>
<spring:message code="user.table.password" var="userPassword"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.delete" var="deleteButton"/>

<spring:eval expression="user.id == null ? addUser : editUser " var="formTitle"/>
<spring:eval expression="user.id == null ? addButton : editButton " var="buttonName"/>
<c:if test="${user.id == null}">
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
<form:form action="/users/save" modelAttribute="user">
    <c:if test="${not empty message}">
        <div id="message" class="${message.type}">${message.message}</div>
        <br>
    </c:if>

    <form:hidden path="id"/>

    <form:label path="firstName">${userFirstName}</form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br>

    <form:label path="lastName">${userLastName}</form:label>
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>

    <form:label path="login">${userLogin}</form:label>
    <form:input path="login"/>
    <form:errors path="login" cssClass="error"/>
    <br>

    <form:label path="password">${userPassword}</form:label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="error"/>
    <br>

    <form:label path="userType">${userUserType}</form:label>
    <form:select path="userType.id">
        <form:options items="${userTypes}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:errors path="userType" cssClass="error"/>
    <br>

    <a href="/crewman/delete/${user.id}"${hidden}>${deleteButton}</a>
    <br>
    <br>

    <input type="submit" value="${buttonName}">
</form:form>
</body>
</html>


