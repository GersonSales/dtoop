<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 12/01/17
  Time: 08:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Check Date</title>
</head>
<body>
    <fmt:formatDate value="${task.checkDate.time}" pattern="dd/MM/yyyy"/>


    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Checked</th>
            <th>CheckDate</th>
        </tr>

        <c:for

        <tr>

        </tr>

    </table>


</body>
</html>
