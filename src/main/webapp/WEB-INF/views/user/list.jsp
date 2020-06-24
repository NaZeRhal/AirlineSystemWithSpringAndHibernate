<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="table.list.action" var="listAction"/>

<spring:message code="user.list.title" var="userListTitle"/>
<spring:message code="user.table.firstName" var="userFirstName"/>
<spring:message code="user.table.lastName" var="userLastName"/>
<spring:message code="user.table.userType" var="userUserType"/>
<spring:message code="user.table.login" var="userLogin"/>
<spring:message code="user.table.password" var="userPassword"/>

<spring:message code="button.add" var="addButton"/>
<spring:message code="button.delete" var="deleteButton"/>
<spring:message code="button.edit" var="editButton"/>
<spring:message code="button.home" var="homeButton"/>

<html>
<head>
    <title>${userListTitle}</title>
    <style type="text/css">
        <%@include file="../../styles/messages.css"%>
        <%@include file="../../styles/custom-style.css"%>
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>${userListTitle}</h2>
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
                    <th>${userFirstName}</th>
                    <th>${userLastName}</th>
                    <th>${userLogin}</th>
                    <th>${userPassword}</th>
                    <th>${userUserType}</th>
                    <th>${listAction}</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.login}</td>
                        <td>${user.password}</td>
                        <td>${user.userType.name}</td>
                        <td>
                            <c:url value="/users/updateForm/${user.id}" var="editUser"/>
                            <c:url value="/users/delete/${user.id}" var="deleteUser"/>
                            <spring:message code="user.delete.confirm" var="deleteConfirm"
                                            arguments="${user.firstName};${user.lastName}"
                                            argumentSeparator=";"/>
                            <a href="${editUser}">${editButton}</a>
                            |
                            <a href="${deleteUser}"
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
