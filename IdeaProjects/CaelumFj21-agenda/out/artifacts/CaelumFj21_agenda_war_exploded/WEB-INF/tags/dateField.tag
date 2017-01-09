<%--
  Created by IntelliJ IDEA.
  User: gersonsales
  Date: 06/01/17
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Date field</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
    <%@  attribute name="id" required="true" %>
    <input id="${id}" name="${id}" placeholder="Born Date">
    <script>
        $("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
    </script>

</body>
</html>
