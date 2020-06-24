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
<spring:message code="button.back" var="backButton"/>

<spring:eval expression="user.id == null ? addUser : editUser " var="formTitle"/>
<spring:eval expression="user.id == null ? addButton : editButton " var="buttonName"/>

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
    <c:if test="${not empty message}">
        <div id="message" class="${message.type}">${message.message}</div>
        <br>
    </c:if>
    <div id="container">
        <form:form action="/users/save" modelAttribute="user">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><form:label path="firstName">${userFirstName}</form:label></td>
                    <td>
                        <form:input path="firstName"/>
                        <form:errors path="firstName" cssClass="error"/>
                    </td>
                </tr>

                <tr>
                    <td><form:label path="lastName">${userLastName}</form:label></td>
                    <td>
                        <form:input path="lastName"/>
                        <form:errors path="lastName" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="login">${userLogin}</form:label></td>
                    <td>
                        <form:input path="login"/>
                        <form:errors path="login" cssClass="error"/>
                    </td>
                </tr>

                <tr>
                    <td><form:label path="password">${userPassword}</form:label></td>
                    <td>
                        <form:input path="password"/>
                        <form:errors path="password" cssClass="error"/>
                    </td>
                </tr>

                <tr>
                    <td><form:label path="userType">${userUserType}</form:label></td>
                    <td>
                        <form:select path="userType.id">
                            <form:options items="${userTypes}" itemLabel="name" itemValue="id"/>
                        </form:select>
                        <form:errors path="userType" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="${buttonName}" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <p>
            <a href="${pageContext.request.contextPath}/users/list">${backButton}</a>
        </p>
    </div>
</div>
</body>
</html>


