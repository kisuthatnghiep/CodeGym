<%@ page import="com.example.minitest.Model.Brand" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/29/2022
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <style>
    form{
      margin-left: auto;
      margin-right: auto;
    }
  </style>
</head>
<body>
<h1 style="text-align: center; margin-bottom: 50px">Update</h1>
<form action="products?action=update&id=${product.getId()}" method="post" style="width: 50%">
  <div class="mb-3">
    <label for="name" class="form-label">Name</label>
    <input type="text" name="name" class="form-control" value="${product.getName()}" id="name">
  </div>
  <div class="mb-3">
    <label for="price" class="form-label">Price</label>
    <input type="text" name="price" class="form-control" value="${product.getPrice()}" id="price">
  </div>
  <div class="mb-3">
    <p>Brand</p>
    <select class="form-select" name="brand" aria-label="Default select example">
      <option value="${product.getBrand().getName()}"><c:out value="${product.getBrand().getName()}"/></option>
      <c:forEach items="${brands}" var="b">
            <option value="${b.getName()}"><c:out value="${b.getName()}"/></option>
      </c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label for="quantity" class="form-label">Quantity</label>
    <input type="text" name="quantity" class="form-control" value="${product.getQuantity()}" id="quantity">
  </div>
  <div style="text-align: center" class="mb-3">
    <button type="submit" class="btn btn-primary">Update</button>
  </div>
</form>
</body>
</html>
