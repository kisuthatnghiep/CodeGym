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
  <h2>Edit employee</h2>
  <form action="EmployeeServlet?action=edit" method="post">
    <div class="mb-3">
      <input name="id" value="${employee.getId()}" hidden>
      <label for="Name" class="form-label">Name</label>
      <input type="text" class="form-control" id="Name" name="name" aria-describedby="emailHelp" value="${employee.getName()}">
    </div>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Email</label>
      <input type="text" class="form-control" name="email" id="exampleInputEmail1" value="${employee.getEmail()}" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
      <label for="address" class="form-label">Address</label>
      <input type="text" class="form-control" name="address" value="${employee.getAddress()}" id="address" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
      <label for="phone" class="form-label">PhoneNumber</label>
      <input type="text" class="form-control" name="phone" value="${employee.getPhone()}" id="phone" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
      <label for="salary" class="form-label">Salary</label>
      <input type="text" class="form-control" name="salary" value="${employee.getSalary()}" id="salary" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
      <label for="department" class="form-label">Department</label>
      <select class="form-select" name="department_id" id="department" aria-label="Default select example">
        <option hidden selected value="${requestScope["employee"].getDepartment().getId()}">${requestScope["employee"].getDepartment().getName()}</option>
        <c:forEach items="${department}" var="dp">
          <option value="${dp.getId()}"><c:out value="${dp.getName()}"/></option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Edit</button>
  </form>
</div>
</body>
</html>
