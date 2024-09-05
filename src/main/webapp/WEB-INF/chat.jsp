
    <%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chat Application</title>
</head>
<body>
<h1>Chat Room</h1>
<form action="/send" method="post">
    Username: <input type="text" name="username" required>
    Message: <input type="text" name="content" required>
    <button type="submit">Send</button>
</form>

<h2>Messages</h2>
<ul>
    <c:forEach var="message" items="${messages}">
        <li><strong>${message.username}:</strong> ${message.content}</li>
    </c:forEach>
</ul>
</body>
</html>