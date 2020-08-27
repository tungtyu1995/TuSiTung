<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/27/2020
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h3 style="text-align: center">Danh Sách Khách Hàng</h3>
<table border="1px" style="width: 100%">
    <tr style="text-align: left">
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
    </tr>
    <c:forEach var="customer" items="${CustomerListServlet}">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.date_of_birth}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
