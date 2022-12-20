<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/12/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary</h2>
<form action="dictionary" method="post">
<input type="text" name="dictionary">
<button type="submit" value="Search">Search</button>
<p>Result: ${translate}</p>
</form>
</body>
</html>
