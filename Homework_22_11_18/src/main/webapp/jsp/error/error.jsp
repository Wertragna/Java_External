<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 19.11.2018
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Error Page</title></head>
    <body> Request from ${pageContext.errorData.requestURI} is failed
        <br/>
        Servlet name or
        type: ${pageContext.errorData.servletName}
        <br/>
        Status code: ${pageContext.errorData.statusCode}
        <br/>
        Exception: ${pageContext.errorData.throwable}
    </body>
</html>
