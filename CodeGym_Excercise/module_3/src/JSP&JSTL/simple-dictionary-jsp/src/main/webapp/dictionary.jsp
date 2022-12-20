<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2022
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dictionary</title>
</head>
<body>
<%
  Map<String,String> dictionary = new HashMap<>();
  dictionary.put("Mom","Mẹ");
  dictionary.put("Dad","Bố");
  dictionary.put("Children","Trẻ em");
  dictionary.put("Sister","Chị gái");
  dictionary.put("Brother","Anh trai");
  String search = request.getParameter("word");
  String result = dictionary.get(search);
  if (result != null){
    out.println("Word: " + search);
    out.println("\nResult: " + result);
  }else {
    out.println("Not found");
  }
%>
</body>
</html>
