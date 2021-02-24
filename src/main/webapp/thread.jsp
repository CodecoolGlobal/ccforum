<%@ page import="com.codecool.ccforum.ui.model.ThreadModel" %>
<%@ page import="com.codecool.ccforum.ui.model.CommentModel" %>
<%@ page import="com.codecool.ccforum.ui.controller.ThreadController" %>
<%@ page import="com.codecool.ccforum.application.Inj" %>

<html>
<head>
    <title>Threads</title>
</head>
<body>


<%
    ThreadController controller = Inj.getInstance(ThreadController.class);
    ThreadModel model = controller.onLoad(request.getParameter("threadId"));
%>
<h1><%= model.getSubject() %></h1>
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