<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 11/01/17
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Added Task</title>
</head>
<body>
    <fmt:message var="task.added.successfully"/>
    <h1>Task has been added successfully!</h1>
    <a href="/newTask">New Task</a>
    <a href="/tasksList">Tasks list</a>
</body>
</html>
