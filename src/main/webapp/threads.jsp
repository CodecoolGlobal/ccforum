<%@ page import="com.codecool.ccforum.ui.model.ThreadListModel" %>
<%@ page import="com.codecool.ccforum.ui.model.ThreadListItemModel" %>
<%@ page import="com.codecool.ccforum.ui.controller.ThreadListController" %>
<%@ page import="com.codecool.ccforum.application.ServiceRegistry" %>

<html>
<head>
    <title>Threads</title>
</head>
<body>

<h1>Threads</h1>
<a href="/newThread.jsp">Create new Thread</a>

<%
    ThreadListController controller = ServiceRegistry.getInstance(ThreadListController.class);
    ThreadListModel model = controller.onLoad();
%>

<%
    for (ThreadListItemModel item : model.getThreads()) {
%>
        <div style="margin-bottom: 8px">
            <div style="font-size: 18px;"><a href="/thread.jsp?threadId=<%= item.getId() %>"><%= item.getSubject() %></a></div>
            <div style="font-size: 14px;"><%= item.getAuthorName() %></div>
        </div>
<%
    }
%>

</body>
</html>