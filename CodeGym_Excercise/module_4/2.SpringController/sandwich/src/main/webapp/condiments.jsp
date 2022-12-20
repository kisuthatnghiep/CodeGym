<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/13/2022
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
    <label for="vehicle1">Lettuce</label>
<input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
    <label for="vehicle2">Tomato</label>
<input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
    <label for="vehicle3">Mustard</label>
<input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="vehicle4">Sprouts</label>
<input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
<button type="submit" value="Save">Save</button>
</form>
<c:forEach items="${condiment}" var="c">
    <p><c:out value="${c}"/></p>
</c:forEach>
</body>
</html>
