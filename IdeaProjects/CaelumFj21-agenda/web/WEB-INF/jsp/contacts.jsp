<%--Created by IntelliJ IDEA.
  User: gersonsales
  Date: 06/01/17
  Time: 06:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
    <c:import url="head.jsp"/>


    <c:import url="addContact.jsp"/>
    <table>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
        </tr>
        <c:forEach var="contact" items="${contacts}" varStatus="id">
            <tr bgcolor="#${id.count % 2 == 0 ? 'B3B6B7' : 'E5E8E8'}" align="center">
                <td>${contact.id}</td>
                <td>${contact.name}</td>
                <td>${contact.age}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty contact.email}">
                            <a href="mailto:${contact.email}">${contact.email}</a>
                        </c:when>

                        <c:otherwise>
                            Not filled
                        </c:otherwise>
                    </c:choose>

                </td>
                <td><a href="mvc?logic=RemoveContactLogic&id=${contact.id}">Remove</a></td>
                <td><a href="mvc?logic=UpdateContactLogic&id=${contact.id}&status=toUpdate">Update</a></td>
            </tr>
        </c:forEach>
    </table>
    <c:import url="foot.jsp"/>
</body>
</html>
