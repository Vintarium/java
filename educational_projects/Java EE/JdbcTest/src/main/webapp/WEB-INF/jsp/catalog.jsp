<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body bgcolor="#2F4F4F">


<div class="text">
<h1>Hello, <%=session.getAttribute("name")%>!</h1>
    <h1>Choose the products you need:</h1>
    <form method="post" action="${pageContext.request.contextPath}/catalogServlet">
        <select name="product">
            <option value="1">Paracetamol - 10$</option>
            <option value="2">Ibuprofen - 20$</option>
            <option value="3">Analgin - 15$</option>
            <option value="4">Aspirin - 12$</option>
            <option value="5">Lapiramid - 8$</option>
            <option value="6">Loratodin - 22$</option>
            <option value="7">Drotoverin - 40$</option>
            <option value="8">Mezim - 52$</option>

            <input type="submit" name="form" value="add">
            <input type="submit" name="form" value="enter">
        </select>
    </form>
</div>
</body>
</html>
