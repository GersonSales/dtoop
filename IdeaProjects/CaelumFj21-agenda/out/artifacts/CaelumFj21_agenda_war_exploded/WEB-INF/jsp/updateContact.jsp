<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 07/01/17
  Time: 03:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="datepicker"%>
<html>
<head>
    <title>Update Contact</title>
</head>
<body>
    <c:import url="head.jsp"/>
    <form method="post"  action="mvc" >
        <label>ID: ${requestScope.id}</label>
        <input type="hidden" name="id" value="${requestScope.id}">
        <input type="text" name="name" placeholder="Enter your name here" value="${requestScope.name}"/>
        <input type="number" name="age" min="18" max="120" placeholder="Age" value="${requestScope.age}"/>
        <input type="email" name="email" placeholder="E-mail" value="${requestScope.email}"/>
        <input type="hidden" name="status" value="update">
        <input type="hidden" name="logic" value="UpdateContactLogic">
        <datepicker:dateField id="bornDate"/>

        <input type="submit" name="Update">
    </form>
    <c:import url="foot.jsp"/>

</body>
</html>
