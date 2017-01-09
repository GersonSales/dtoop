<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="datepicker"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new contact</title>
    <link href="../../js/jquery-ui.css" rel="stylesheet">
    <script href="js/external/jquery/jquery.js"></script>
    <script href="js/jquery-ui.js"></script>
</head>
<body>
    <form method="post" action="mvc">
        <input type="text" name="name" placeholder="Enter your name here"/>
        <input type="number" name="age" min="18" max="120" placeholder="Age"/>
        <input type="email" name="email" placeholder="E-mail"/>
        <input type="hidden" name="logic" value="AddContactLogic"/>
        <datepicker:dateField id="bornDate"/>

        <input type="submit" name="Submit"/>
    </form>
</body>
</html>