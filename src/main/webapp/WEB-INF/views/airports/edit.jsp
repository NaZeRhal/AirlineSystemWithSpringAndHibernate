<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<spring:message code="airports.add.title" var="addAirport"/>
<spring:message code="airports.edit.title" var="editAirport"/>
<spring:message code="airports.table.city" var="airportCity"/>
<spring:message code="airports.table.code" var="airportCode"/>
<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.delete" var="deleteButton"/>
<spring:message code="button.back" var="backButton"/>

<spring:eval expression="airport.id == null ? addAirport : editAirport " var="formTitle"/>
<spring:eval expression="airport.id == null ? addButton : editButton " var="buttonName"/>

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
            <form:form action="/airports/save" modelAttribute="airport">
                <c:if test="${not empty message}">
                    <div id="message" class="${message.type}">${message.message}</div>
                </c:if>
                <form:hidden path="id"/>
                <table>
                    <tbody>
                    <tr>
                        <td><form:label path="city">${airportCity}</form:label></td>
                        <td><form:input path="city"/>
                            <form:errors path="city" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="airportCode">${airportCode}</form:label></td>
                        <td><form:input path="airportCode"/>
                            <form:errors path="airportCode" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="${buttonName}"></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
            <p>
                <a href="${pageContext.request.contextPath}/users/list">${backButton}</a>
            </p>
        </div>
    </div>
</div>


</body>
</html>

