<%--
  Created by IntelliJ IDEA.
  User: Nguyen Tien Thanh
  Date: 28/11/2022
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>
<body>
<h1 style="text-align: center;margin-bottom: 50px">Product List</h1>
<a style="margin-left: 350px" href="create-product.jsp">add product</a>
<table class="table table-striped" style="width: 50%;margin-left: auto;margin-right: auto; margin-top: 20px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Brand</th>
        <th>Quantity</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td><c:out value="${p.getId()}"/></td>
            <td><c:out value="${p.getName()}"/></td>
            <td><c:out value="${p.getPrice()}"/></td>
            <td><c:out value="${p.getBrand().getName()}"/></td>
            <td><c:out value="${p.getQuantity()}"/></td>
            <td><a href="#"><i class="bi bi-trash" onclick="referenceDelete(${p.getId()})" data-bs-toggle="modal" data-bs-target="#delete"></i></a></td>
            <td><a href="products?action=showEditForm&id=${p.getId()}"><i class="bi bi-pencil-square"></i></a></td>
        </tr>
    </c:forEach>
</table>
<!-- Modal delete -->
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Confirm</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure want to delete?
            </div>
            <div class="modal-footer" id="delete-parameter">
                <a href="products?action=delete" onclick="location.href=this.href+'&id='+a;return false;" id="a">
                    <button type="button" class="btn btn-primary">Yes</button></a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<script src="product.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

