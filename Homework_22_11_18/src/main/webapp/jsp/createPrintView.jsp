<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 27.11.2018
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<form name="loginForm" method="POST" action="">
    <input type="hidden" name="command" value="login"/>

    <input type="text" name="code" placeholder="code" value=""/>
    <br/>
    <input type="text" name="model" placeholder="model" value=""/>
    <br/>
    <input type="text" name="color" placeholder="color" value=""/>
    <br/>
    <input type="text" name="type" placeholder="type" value=""/>
    <br/>
    <input type="text" name="price" placeholder="price" value=""/>
    <br/> ${errorLoginPassMessage}
    <br/> ${wrongAction}
    <br/> ${nullPage}
    <br/>
    <input type="submit" name="login1" value="Log in"/>
    <a href="${pageContext.request.contextPath}/productList">Cancel</a>
</form>
</body>
</html>
