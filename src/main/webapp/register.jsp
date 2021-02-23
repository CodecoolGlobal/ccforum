<%@ page import="com.codecool.ccforum.ui.controller.AuthController" %>
<%@ page import="com.codecool.ccforum.application.ServiceRegistry" %>

<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        AuthController ctrl = ServiceRegistry.getInstance(AuthController.class);
        ctrl.onRegister(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
        response.sendRedirect("/login.jsp");
    }
    //return;
%>

<html>
<head>
    <title>Register</title>
</head>
<body>

<h1>Register</h1>

<form method="POST">
    Name: <input name="name" type="text"/><br/>
    Email: <input name="email" type="email"/><br/>
    Password: <input name="password" type="password"/><br/>
    <input type="submit"/><br/>
</form>

</body>
</html>