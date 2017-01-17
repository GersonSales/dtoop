<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 12/01/17
  Time: 03:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Show task</title>
</head>
<body>
    <c:import url="menuBar.jsp"/>
    <h1>Update ${task}</h1>

    <form action="/updateTask" method="post">
        <input type="hidden" name="id" value="${task.id}">
        Description:<br/>
        <textarea name="description" rows="5" cols="100">${task.description}</textarea><br/>
        Checked: <input type="checkbox" name="checked" value="true" ${task.checked ? 'checked' :''}><br/>
        CheckDate: <br/>
        <input type="text" name="checkDate" value="<fmt:formatDate value="${task.checkDate.time}" pattern='dd/MM/yyyy'/>"><br/>
        <input type="submit" value="Update">


    </form>

</body>
</html>
