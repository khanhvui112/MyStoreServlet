<%--
  Created by IntelliJ IDEA.
  User: san vui
  Date: 11/11/2021
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>JSP - Hello World</title>
  </head>
  <body>
    <h1><%= "Hello World Day la Vui!" %>
    </h1>
    <p>${loginDTO.getUserName()}</p>
    <br/>
    <a href="./login">Login</a>
  </body>
</html>