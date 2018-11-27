<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 18.11.2018
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Login</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
    <form name="loginForm" method="POST" action="login-user">
        <input type="hidden" name="command" value="login"/>

        <input type="text" name="login"  placeholder="Username" value=""/>
        <br/>
        <input type="password" name="password" placeholder="Password" value=""/>
        <br/> ${errorLoginPassMessage}
        <br/> ${wrongAction}
        <br/> ${nullPage}
        <br/> <input type="submit" name="login1" value="Log in"/>
        <input type="submit"  style="color: white" name="registration" value="Registration"/>

</body>
</html>
