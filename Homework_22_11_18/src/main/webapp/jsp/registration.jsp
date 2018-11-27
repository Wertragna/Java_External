<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 18.11.2018
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<form name="registrationForm" method="POST" action="controller">
    <input type="hidden" name="command" value="registration"/>
    Login:
    <br/>
    <input type="text" name="login" value=""/>
    <br/>
    Password:
    <br/>
    <input type="password" name="password" value=""/>
    <br/>


    <br/> ${errorLoginPassMessage}
    <br/> ${wrongAction}
    <br/> ${nullPage}
    <br/> <input type="submit" value="Registration"/>
</form>
<hr/>
</body>
</html>
