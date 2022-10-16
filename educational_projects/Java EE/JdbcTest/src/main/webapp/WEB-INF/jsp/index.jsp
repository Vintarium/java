<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <title>Catalog</title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body bgcolor="#2F4F4F">


<div class="text"><h1>Welcome to shop!</h1></div>
<div class="text"><h1>Autorized, please!</h1></div>
<div class="text">
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <p><input type="text" name="name" placeholder="Enter your name"></p>
        <p><input type="checkbox" name="checkbox" checked>
            I support the revolution of consciousness and am ready to
            fight against the policy of ignorance
            and the parasite called the state in the name of peace, truth, honor and justice.</p>
        <p>

            <button type="submit" value="Enter">Enter</button>
        </p>
    </form>
</div>


</body>
</html>
