<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/8/2022
  Time: 9:07 AM
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
<h2>Add new employee</h2>
<form method="post" action="EmployeeServlet?action=create">
    <div class="mb-3">
        <label for="Name" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="Name" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <input type="text" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" name="address" class="form-control" id="address" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">PhoneNumber</label>
        <input type="text" name="phone" class="form-control" id="phone" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="salary" class="form-label">Salary</label>
        <input type="text" name="salary" class="form-control" id="salary" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="department" class="form-label">Department</label>
    <select class="form-select" name="department_id" id="department" aria-label="Default select example">
        <option selected>Open this select menu</option>
        <c:forEach items="${department}" var="dp">
            <option value="${dp.getId()}"><c:out value="${dp.getName()}"/></option>
        </c:forEach>
    </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>
