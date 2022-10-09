<%@ page import="com.example.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Users</h1>
<table>
    <tr>
        <th>Name</th>
    </tr>
    <% for (User user : (List<User>) request.getAttribute("registered_users")) {%>
    <tr>
        <td>
            <%=user.getUserName()%>
        </td>
    </tr>
    <%} %>
</table>
</body>
</html>