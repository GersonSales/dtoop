<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 11/01/17
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Task form</title>
</head>
<body>

    <c:import url="menuBar.jsp"/>
    <h1>Add task</h1>

    <form:errors path="task.description" cssStyle="color: red"/>
    <form action="addTask" method="post">
        Description<br/>
        <textarea name="description" rows="5" cols="100"></textarea><br/>
        <input type="submit" value="Add task">


    </form>

</body>
</html>
