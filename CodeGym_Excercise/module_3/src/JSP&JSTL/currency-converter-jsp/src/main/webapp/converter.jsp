<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2022
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
  float rate = Float.parseFloat(request.getParameter("rate"));
  float USD = Float.parseFloat(request.getParameter("USD"));
  float VND = rate*USD;
%>
<h1>Rate: <%=rate%></h1>
<h1>USD: <%=USD%></h1>
<h1>VND: <%=VND%></h1>
</body>
</html>
