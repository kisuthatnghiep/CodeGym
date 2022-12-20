<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/12/2022
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Change money</h2>
<form action="change" method="post">
<input type="text" name="money">
<input type="submit" value="Change">
</form>
<p>Result: ${money}</p>
</body>
</html>
