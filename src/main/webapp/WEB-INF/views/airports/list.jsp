<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<spring:message code="table.list.action" var="listAction"/>

<spring:message code="airports.list.title" var="airportListTitle"/>
<spring:message code="airports.table.city" var="airportCity"/>
<spring:message code="airports.table.code" var="airportCode"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.home" var="homeButton"/>
<spring:message code="button.delete" var="deleteButton"/>


<html>
<head>
    <title>${airportListTitle}</title>
    <style type="text/css">
        <%@include file="../../styles/messages.css"%>
        <%@include file="../../styles/custom-style.css"%>
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>${airportListTitle}</h2>
    </div>
    <div id="container">
        <div id="content">
            <c:if test="${not empty message}">
                <div id="message" class="${message.type}">${message.message}</div>
                <br>
            </c:if>
            <input type="button" value="${addButton}"
                   onclick="window.location.href='createForm'; return false;"
                   class="add-button"/>
            <table>
                <tr>
                    <th>${airportCity}</th>
                    <th>${airportCode}</th>
                    <th>${listAction}</th>
                </tr>
                <c:forEach var="airport" items="${airports}">
                    <tr>
                        <td>${airport.city}</td>
                        <td>${airport.airportCode}</td>
                        <td>
                            <c:url value="/airports/updateForm/${airport.id}" var="editAirport"/>
                            <c:url value="/airports/delete/${airport.id}" var="deleteAirport"/>
                            <spring:message code="airport.delete.confirm" var="deleteConfirm"
                                            arguments="${airport.city};${airport.airportCode}"
                                            argumentSeparator=";"/>
                            <a href="${editAirport}">${editButton}</a>
                            |
                            <a href="${deleteAirport}"
                               onclick="if (!(confirm('${deleteConfirm}'))) return false;">${deleteButton}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<c:url value="/" var="homeUrl"/>
<h3><a href="${homeUrl}">${homeButton}</a></h3>

</body>
</html>
