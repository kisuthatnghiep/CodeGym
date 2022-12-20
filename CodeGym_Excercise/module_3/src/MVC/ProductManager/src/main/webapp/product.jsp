<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/28/2022
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,th,td{
            border: 1px solid black;
            border-collapse: collapse;
        }
        th,td{
            text-align: center;
            width: 100px;
        }
    </style>
</head>
<body>
<h1>Product Manager</h1>
<a href="Create.jsp">Create product</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
    </tr>
<c:forEach items="${products}" var="p">
    <tr>
        <td><c:out value="${p.getId()}"/></td>
        <td><c:out value="${p.getName()}"/></td>
        <td><c:out value="${p.getPrice()}"/></td>
        <td><c:out value="${p.getDescription()}"/></td>
        <td><c:out value="${p.getProducer()}"/></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
