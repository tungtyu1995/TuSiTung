<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2020
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.js" ></script>

<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
<h1>Product Management</h1>
<h2>
    <a href="/product">Back to list product</a>
</h2>
</center>
<div align="center">
    <caption><h2>List of Product</h2></caption>

    <table style="border-collapse: collapse" border="1" cellpadding="5">

        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Descriptions</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${listFindCountry}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><a href="/product?action=edit&id=${product.id}"><c:out value="${product.name}"/></a></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.descriptions}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.id}">Edit</a>
                    <a href="/product?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>