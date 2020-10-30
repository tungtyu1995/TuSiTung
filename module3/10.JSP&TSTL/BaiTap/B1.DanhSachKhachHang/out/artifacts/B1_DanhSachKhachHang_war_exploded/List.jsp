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
    <style>
        table{
            font-size: 30px;
            border-collapse: collapse;
            width: 100%;
        }
        table,th,td{
            border: 1px solid black;
        }
        th,td{
            padding: 5px;
        }
        tr:nth-child(even){
            background-color: aliceblue;
            text-align: center;
        }
        th{
            background-color: crimson;
            color: white;
        }
        h2{
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Danh Sách Khách Hàng</h2>
<table>
    <tr style="text-align: center">
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${CustomerListServlet}">
        <tr style="text-align: center">
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.date_of_birth}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img width="150px" height="150px" src="${customer.imageURL}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
