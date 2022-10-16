<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.12.2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageOne</title>
</head>
<body>


<div align="center"  style="padding-top: 200px; font-size: 30px">Welcome to online shop</div>
<%--<div align= "center";style= "padding-top: 100px"><form  action= "#" method = "POST">--%>

<div align="center" style="padding-top: 100px">

    <form action="${pageContext.request.contextPath}/login" method="POST">
        <input name="name" ; type="text" ; placeholder="Enter your name">
        <p style="margin-bottom: 15px">
            <input type="checkbox" ; name="checkbox" checked>I agree with the terms of service</p>
        <input type="submit" value="Enter"> </p> </form>
</div>


</body>
</html>


