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
<spring:message code="button.back" var="backButton"/>

<spring:eval expression="crewman.id == null ? addCrewman : editCrewman " var="formTitle"/>
<spring:eval expression="crewman.id == null ? addButton : editButton " var="buttonName"/>

<html>
<head>
    <title>${formTitle}</title>
    <style type="text/css">
        <%@include file="../../styles/messages.css"%>
        <%@include file="../../styles/custom-style.css"%>
        <%@include file="../../styles/edit-form-style.css"%>
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>${formTitle}</h2>
    </div>
    <div id="container">
        <div id="content">
            <c:if test="${not empty message}">
                <div id="message" class="${message.type}">${message.message}</div>
                <br>
            </c:if>

            <form:form action="/crewman/save" modelAttribute="crewman">
                <form:hidden path="id"/>
                <table>
                    <tbody>
                    <tr>
                        <td><form:label path="firstName">${crewmanFirstName}</form:label></td>
                        <td>
                            <form:input path="firstName"/>
                            <form:errors path="firstName" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="lastName">${crewmanLastName}</form:label></td>
                        <td>
                            <form:input path="lastName"/>
                            <form:errors path="lastName" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="dateOfBirth">${crewmanBirthDate}</form:label></td>
                        <td>
                            <form:input path="dateOfBirth" placeholder="dd.MM.yyyy"/>
                            <form:errors path="dateOfBirth" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="profession">${crewmanProfession}</form:label></td>
                        <td>
                            <form:select path="profession.id">
                                <form:options items="${professions}" itemLabel="name" itemValue="id"/>
                            </form:select>
                            <form:errors path="profession" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="${buttonName}"></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
            <p>
                <a href="${pageContext.request.contextPath}/crewman/list">${backButton}</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>

