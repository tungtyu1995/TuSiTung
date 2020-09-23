<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/12/2020
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>

<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/matBang?action=create">Thêm Mới</a>
    </h2>
</center>

<div align="center">
    <form method="post" action="/matBang">
        <input type="hidden" name="action" value="timKiemTheoLoaiVP">
        <input type="text" name="loaiVanPhong" placeholder="tìm kiếm theo loại văn phòng">
        <input type="submit" value="Search">
    </form>
</div>

<div align="center">
    <form method="post" action="/matBang">
        <input type="hidden" name="action" value="timKiemTheoGia">
        <input type="number" min="1000000" name="gia"  placeholder="tìm kiếm theo giá">
        <input type="submit" value="Search">
    </form>
</div>

<div align="center">
    <form method="post" action="/matBang">
        <input type="hidden" name="action" value="timKiemTheoTang">
        <input type="text" name="tang"  placeholder="tìm kiếm theo tầng">
        <input type="submit" value="Search">
    </form>
</div>


<div align="center">
    <a href="/matBang?action=">
        <caption><h2>Danh Sách Mặt Bằng</h2></caption>
    </a>
    <table style="border-collapse: collapse" border="1" cellpadding="5">

        <tr>
            <th>Mã Mặt Bằng</th>
            <th>Diện Tích</th>
            <th>Trạng Thái</th>
            <th>Tầng</th>
            <th>Loại Văn Phòng</th>
            <th>Giá Cho Thuê</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="obj" items="${listObj}">
            <tr>
<%--                id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc--%>
                <td><c:out value="${obj.id}"/></td>
                <td><c:out value="${obj.dienTich}"/></td>
                <td><c:out value="${obj.trangThai}"/></td>
                <td><c:out value="${obj.tang}"/></td>
                <td><c:out value="${obj.loaiVanPhong}"/></td>
                <td><c:out value="${obj.gia}"/></td>
                <td><c:out value="${obj.ngayBatDau}"/></td>
                <td><c:out value="${obj.ngayKetThuc}"/></td>
                <td>
                    <a href="/matBang?action=delete&id=${obj.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
