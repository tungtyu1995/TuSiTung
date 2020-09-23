<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2020
  Time: 9:37 PM
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
        <a href="product?action=">List All Product</a>
    </h2>
</center>
<div align="center">
    <caption>
        <h2>
            Edit Product
        </h2>
    </caption>
    <form method="post">
        <table style="border-collapse: collapse" border="1" cellpadding="5">

            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>

            <tr>
                <td>Product Name:</td>
                <td>
                    <input type="text" name="name" class="form-control" title="Nhập vào tên sản phẩm "
                           value="<c:out value='${product.name}' />"
                           required>
                </td>
            </tr>

            <tr>
                <td>Product Price:</td>
                <td>
                    <input type="number" min="1" step="any" name="price" class="form-control" title="Nhập vào giá sản phẩm"
                           value="<c:out value='${product.price}' />"
                           required>
                </td>

            <tr>
                <td>Product Quantity:</td>
                <td>
                    <input type="number" min="1" name="quantity" class="form-control"
                           value="<c:out value='${product.quantity}' />"
                           required>
                </td>
            </tr>

            <tr>
                <td>Product Color:</td>
                <td>
                    <input type="text" name="color" class="form-control"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>

            <tr>
                <td>Product Descriptions:</td>
                <td>
                    <input type="text" name="descriptions" class="form-control"
                           value="<c:out value='${product.descriptions}' />"
                    />
                </td>
            </tr>

            <tr>
                <td>Product Category:</td>
                <td>
                    <input type="text" name="category" class="form-control"
                           value="<c:out value='${product.category}' />"
                    />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <a href="product?action="><input type="button" value="Cancel"></a>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>