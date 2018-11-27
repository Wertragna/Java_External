<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 26.11.2018
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Product List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Code</th>
        <th>Model</th>
        <th>Color</th>
        <th>Type</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${productList}" var="product" >
        <tr>
            <td>${product.code}</td>
            <td>${product.model}</td>
            <td>${product.color}</td>
            <td>${product.type}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
