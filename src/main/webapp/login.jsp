<%@ page import="com.codecool.ccforum.ui.controller.AuthController" %>
<%@ page import="com.codecool.ccforum.application.ServiceRegistry" %>
<%@ page import="javax.servlet.http.Cookie" %>

<%
    boolean isLoginFailed = false;
    if (request.getMethod().equalsIgnoreCase("POST")) {
        AuthController ctrl = ServiceRegistry.getInstance(AuthController.class);
        Long ssid = ctrl.onLogin(request.getParameter("email"), request.getParameter("password"));
        if (ssid == null) {
            isLoginFailed = true;
        } else {
            Cookie cookie = new Cookie("ssid", "" + ssid);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
            response.sendRedirect("/threads.jsp");
        }
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Login</h1>

<% if (isLoginFailed) { %>
    <div style="color: red">Invalid email or password!</div><br/>
<% } %>

<form method="POST">
    Email: <input name="email" type="email"/><br/>
    Password: <input name="password" type="password"/><br/>
    <input type="submit"/><br/>
</form>

</body>
</html>