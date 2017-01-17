<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 12/01/17
  Time: 03:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <title>Tasks list</title>
</head>
<body>
    <c:import url="menuBar.jsp"/>
    <script type="text/javascript" >
        function checkNow(id) {
            $.get("checkTask", {'id': id}, function (response) {
                $("#task_"+id).html("Checked");
            })
        }
    </script>

    <table align="center">
        <tr align="center">
            <th>ID</th>
            <th>Description</th>
            <th>Checked</th>
            <th>CheckDate</th>
        </tr>

        <c:forEach var="task" items="${tasks}" >
            <tr align="center">
                <td>${task.id}</td>
                <td>${task.description}</td>
                <c:choose>
                    <c:when test="${task.checked eq false}">
                        <td id="task_${task.id}">
                            <a href="#" onclick="checkNow(${task.id})">Check now</a>
                        </td>

                    </c:when>
                    <c:otherwise>
                        <td>Checked</td>
                    </c:otherwise>
                </c:choose>

                <td id="task_date_${task.id}">
                    <fmt:formatDate value="${task.checkDate.time}" pattern="dd/MM/yyy"/>
                </td>
                <td><a href="/removeTask?id=${task.id}">Remove</a></td>
                <td><a href="/showTask?id=${task.id}">Update</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
