<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/8/2022
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Display Employee</h2>
    <br>
    <div class="container">
        <form action="EmployeeServlet?action=search" method="post">
        <div class="row">
            <div class="col col-md-5">
                <input type="text" name="search" class="form-control" aria-describedby="emailHelp">
            </div>
            <div class="col col-md-7">
                <button class="btn btn-primary">Search</button>
            </div>
        </div>
        </form>
    </div>
    <br>
    <a href="EmployeeServlet?action=openCreate" style="text-decoration: none">Create employee</a>
    <table class="table table-striped" style="margin-top: 20px">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>phoneNumber</th>
            <th>Salary</th>
            <th>Department</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${employees}" var="e">
            <tr>
                <td>${e.getId()}</td>
                <td>${e.getName()}</td>
                <td>${e.getEmail()}</td>
                <td>${e.getAddress()}</td>
                <td>${e.getPhone()}</td>
                <td>${e.getSalary()}</td>
                <td>${e.getDepartment().getName()}</td>
                <td><a href="EmployeeServlet?action=editForm&id=${e.getId()}"><button type="button" class="btn btn-primary">Edit</button></a></td>
                <td><a href="#"><button type="button" class="btn btn-danger"  onclick="referenceDelete(${e.getId()})" data-bs-toggle="modal" data-bs-target="#delete1">Delete</button></a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<!-- Modal delete -->
<div class="modal fade" id="delete1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                <a href="EmployeeServlet?action=delete" onclick="location.href=this.href+'&id='+a;return false;" id="a">
                    <button type="button" class="btn btn-primary">Yes</button></a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<script src="js.js">
</script>
</body>
</html>
