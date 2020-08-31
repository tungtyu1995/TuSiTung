<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/30/2020
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            font-size: 30px;
            border-collapse: collapse;
            width: 100%;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 5px;
        }

        tr:nth-child(even) {
            background-color: aliceblue;
            text-align: center;
        }

        th {
            background-color: crimson;
            color: white;
        }

    </style>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<h3>
    <a href="/product?action=create">Create new product</a>
</h3>
<form method="get" action="/findName">
    <fieldset style="width: 25%">
        <h3>Search name product</h3>
        <input type="text" name="productName" id="productName">
        <input type="submit" value="View product">
    </fieldset>
</form>

<table>
    <tr style="text-align: center">
        <th>Name</th>
        <th>Price</th>
        <th>Describe</th>
        <th>Made by</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr style="text-align: center">
            <td><a href="/product?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
            <td>${product.getProductPrice()}</td>
            <td>${product.getProductDescribe()}</td>
            <td>${product.getProductBy()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>