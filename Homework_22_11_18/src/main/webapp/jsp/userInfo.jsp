<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 27.11.2018
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
</head>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello: ${user}</h3>
<a href="userInfo?command=logout">Logout</a></body>
</body>
</html>
