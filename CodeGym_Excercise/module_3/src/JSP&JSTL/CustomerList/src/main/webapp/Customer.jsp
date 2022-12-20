<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/28/2022
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  td{
    text-align: center;
  }
  img{
    width: 20%;
  }
</style>
<body>
<h1>Danh sách khách hàng</h1>
<table style="width: 100%">
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${customers}" var="c">
    <tr>
      <td><c:out value="${c.getName()}"/></td>
      <td><c:out value="${c.getBirth()}"/></td>
      <td><c:out value="${c.getAddress()}"/></td>
      <td width="10%"><img src="${c.getSourceImg()}" alt="t"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
