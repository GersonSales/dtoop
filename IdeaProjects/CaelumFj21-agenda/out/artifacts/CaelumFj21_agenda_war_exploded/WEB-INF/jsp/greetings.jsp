<%@ page import="caelum.contact.Contact" %>
<%@ page import="caelum.database.DAO" %><%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 06/01/17
  Time: 03:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greetrings</title>
</head>
<body>

    <%
        String message =  "Welcome!";
        out.println(message);

        Contact contact = new Contact("name", 21);
        DAO dao = new DAO();

        dao.addContact(contact);
        System.out.println("Done!");
    %>

</body>
</html>
