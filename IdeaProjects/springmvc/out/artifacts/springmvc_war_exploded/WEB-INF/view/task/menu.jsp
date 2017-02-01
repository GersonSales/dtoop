<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 13/01/17
  Time: 06:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:import url="menuBar.jsp"/>
    <h2>Welcome ${loggedUser.login}</h2>
</body>
</html>
