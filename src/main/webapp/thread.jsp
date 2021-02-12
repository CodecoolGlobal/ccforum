<%@ page import="com.codecool.ccforum.ui.model.ThreadModel" %>
<%@ page import="com.codecool.ccforum.ui.model.CommentModel" %>
<%@ page import="com.codecool.ccforum.ui.controller.ThreadController" %>
<%@ page import="com.codecool.ccforum.application.ServiceRegistry" %>

<html>
<head>
    <title>Threads</title>
</head>
<body>

<h1>Threads</h1>

<%
    ThreadController controller = ServiceRegistry.getInstance(ThreadController.class);
    ThreadModel model = controller.onLoad(request.getParameter("threadId"));
%>

<h2><%= model.getSubject() %></h2>
<p>
    <%= model.getDescription() %>
</p>

<%
    for (CommentModel item : model.getComments()) {
%>
        <div style="margin-bottom: 8px">
            <div style="font-size: 14px;"><%= item.getAuthorName() %></div>
            <div style="font-size: 18px;"><%= item.getContent() %></div>
        </div>
<%
    }
%>

</body>
</html>