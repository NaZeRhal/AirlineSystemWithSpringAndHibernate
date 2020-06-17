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
<c:if test="${airport.id == null}">
    <c:set var="hidden" value="hidden"/>
</c:if>

<html>
<head>
    <title>${formTitle}</title>
    <style type="text/css" >
        .error {color:red}
    </style>
</head>
<body>
<h2>${formTitle}</h2>
<form:form action="/airports/save" modelAttribute="airport" >

    <c:if test="${not empty message}">
        <div id="message" class="${message.type}">${message.message}</div>
    </c:if>
    <br>
    <br>
    <form:hidden path="id"/>

    <form:label path="city">${airportCity}</form:label>
    <form:input path="city"/>
    <form:errors path="city" cssClass="error"/>
    <p/>

    <form:label path="airportCode">${airportCode}</form:label>
    <form:input path="airportCode"/>
    <form:errors path="airportCode" cssClass="error"/>
    <p/>

    <a href="/airports/delete/${airport.id}" ${hidden}>${deleteButton}</a>
    <br>
    <br>

    <input type="submit" value="${buttonName}">
</form:form>
</body>
</html>

