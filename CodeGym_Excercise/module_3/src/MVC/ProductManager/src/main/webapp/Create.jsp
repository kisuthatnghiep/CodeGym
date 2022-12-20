<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/28/2022
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <!-- CSS only -->
  <style>
    .create{
      margin-left: 50px;
    }
  </style>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1>Create product</h1>
  <form class="row g-3" action="products?action=create" method="post" >
    <div class="col-md-12 create"><div class="col-md-3">
      <label for="id" class="form-label">ID</label>
      <input type="text" name="id" class="form-control" id="id">
    </div></div>
    <div class="col-md-12 create"><div class="col-md-3">
      <label for="name" class="form-label">Name</label>
      <input type="text" name="name" class="form-control" id="name">
    </div></div>
    <div class="col-md-12 create"><div class="col-3">
      <label for="price" class="form-label">Price</label>
      <input type="text" name="price" class="form-control" id="price">
    </div></div>
    <div class="col-md-12 create"><div class="col-3">
      <label for="description" class="form-label">Description</label>
      <input type="text" class="form-control" name="description" id="description">
    </div></div>
    <div class="col-md-12 create"><div class="col-3">
      <label for="producer" class="form-label">Producer</label>
      <input type="text" name="producer" class="form-control" id="producer">
    </div></div>
    <div class="col-3 create">
    <button type="submit" class="btn btn-primary"><a style="text-decoration: none; color: white" href="products">Submit</a></button>
    </div>
  </form>
</body>
</html>
