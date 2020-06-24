<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="table.list.action" var="listAction"/>

<spring:message code="crewman.list.title" var="crewmenListTitle"/>
<spring:message code="crewman.table.firstName" var="crewmanFirstName"/>
<spring:message code="crewman.table.lastName" var="crewmanLastName"/>
<spring:message code="crewman.table.profession" var="crewmanProfession"/>
<spring:message code="crewman.table.dateOfBirth" var="crewmanBirthDate"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.delete" var="deleteButton"/>
<spring:message code="button.home" var="homeButton"/>

<html>
<head>
    <title>${crewmenListTitle}</title>
    <style type="text/css">
        <%@include file="../../styles/messages.css"%>
        <%@include file="../../styles/custom-style.css"%>
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>${crewmenListTitle}</h2>
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
                <tbody>
                <tr>
                    <th>${crewmanFirstName}</th>
                    <th>${crewmanLastName}</th>
                    <th>${crewmanBirthDate}</th>
                    <th>${crewmanProfession}</th>
                    <th>${listAction}</th>
                </tr>
                <c:forEach var="crewman" items="${crewmanList}">
                    <tr>
                        <td>${crewman.firstName}</td>
                        <td>${crewman.lastName}</td>
                        <td>${crewman.birthDateString}</td>
                        <td>${crewman.profession.name}</td>
                        <td>
                            <c:url value="/crewman/updateForm/${crewman.id}" var="editCrewMan"/>
                            <c:url value="/crewman/delete/${crewman.id}" var="deleteCrewMan"/>
                            <spring:message code="crewman.delete.confirm" var="deleteConfirm"
                                            arguments="${crewman.firstName};${crewman.lastName}"
                                            argumentSeparator=";"/>
                            <a href="${editCrewMan}">${editButton}</a>
                            |
                            <a href="${deleteCrewMan}"
                            onclick="if (!(confirm('${deleteConfirm}'))) return false;">${deleteButton}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

<c:url value="/" var="homeUrl"/>
<h4><a href="${homeUrl}">${homeButton}</a></h4>

</body>
</html>
