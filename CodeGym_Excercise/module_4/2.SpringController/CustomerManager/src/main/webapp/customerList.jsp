<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/13/2022
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <spring:url value="bootstrap/css/bootstrap.min.css"/>
    <link href="<c:url value="bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<h2>Customer List</h2>
<table class="table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.getId()}"/></td>
            <td><c:out value="${customer.getName()}"/></td>
            <td><c:out value="${customer.getEmail()}"/></td>
            <td><c:out value="${customer.getAddress()}"/></td>
        </tr>
    </c:forEach>
</table>
<button class="btn btn-primary">Add</button>
</body>
</html>
