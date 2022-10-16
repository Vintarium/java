<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body bgcolor="#2F4F4F">

<div class="text">
    <h1> Dear, <%=session.getAttribute("name")%>, your order: </h1>
    <h3>Customer id : <%=session.getAttribute("id")%>
    </h3>

    <h3>Customer name : <%=session.getAttribute("name")%>
    </h3>

    <h3> Customer products : <%=session.getAttribute("allProducts")%>
    </h3>

    <h3>Customer тo pay : <%=session.getAttribute("totalPrice")%>
    </h3>

    <h1>Good bay!</h1>


</div>


</body>
</html>
