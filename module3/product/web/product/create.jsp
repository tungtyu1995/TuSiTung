<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2020
  Time: 9:36 PM
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
        <a href="/product?action=products">List All Product</a>
    </h2>
</center>
<div align="center">
    <h2>Add New Product</h2>
    <form method="post">
        <table style="border-collapse: collapse" border="1" cellpadding="5">

            <tr>
                <td>Product Name:</td>
                <td>
                    <input type="text" name="name" id="name" title="nhập vào tên sản phẩm" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Product Price:</td>
                <td>
                    <input type="number" step="any" min="1" title="nhập vào giá sản phẩm"  name="price" id="price" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Product Quantity:</td>
                <td>
                    <input type="number" min="1" title="Nhập vào số lượng sản phẩm" name="quantity" id="quantity" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Product Color:</td>
                <td>
                    <input type="text" name="color" title="Nhập vào màu sắc sản phẩm" id="color" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Product Descriptions:</td>
                <td>
                    <input type="text" title="Nhập vào mô tả sản phẩm" name="descriptions" id="descriptions" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Product Category: </td>
                <td>
                    <select name="category" title="Chọn danh mục sản phẩm" >
                        <option value="Computer">Computer</option>
                        <option value="Phone">Phone</option>
                        <option value="Television">Television</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <a href="/product?action=products"><input type="button" value="Done"></a>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>