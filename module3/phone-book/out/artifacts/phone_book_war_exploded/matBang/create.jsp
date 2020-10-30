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
    <title>CHO THUE MAT BANG</title>
</head>
<body>
<center>
    <h1>Quản lý thuê mặt bằng</h1>
    <h2>
        <a href="/matBang?action=">Danh Sách Mặt Bằng</a>
    </h2>
</center>
<div align="center">
    <h2>Thêm Mới Mặt Bằng</h2>
    <form method="post">
        <table style="border-collapse: collapse" border="1" cellpadding="5">
            <%--            id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc--%>
            <tr>
                <td>Mã Mặt Bằng:</td>
                <td>
                    <input type="text" name="id" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Diện Tích:</td>
                <td>
                    <input type="number" min="20" name="dienTich" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Trạng Thái:</td>
                <td>
                    <select name="trangThai" title="Chọn danh mục sản phẩm">
                        <option value="Trống">Trống</option>
                        <option value="Hạ Tầng">Hạ Tầng</option>
                        <option value="Đầy Đủ">Đây Đủ</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Tầng:</td>
                <td>
                    <select name="tang" title="Chọn danh mục sản phẩm">
                        <option value="1">tầng 1</option>
                        <option value="2">tầng 2</option>
                        <option value="3">tầng 3</option>
                        <option value="4">tầng 4</option>
                        <option value="5">tầng 5</option>
                        <option value="6">tầng 6</option>
                        <option value="7">tầng 7</option>
                        <option value="8">tầng 8</option>
                        <option value="9">tầng 9</option>
                        <option value="10">tầng 10</option>
                        <option value="11">tầng 11</option>
                        <option value="12">tầng 12</option>
                        <option value="13">tầng 13</option>
                        <option value="14">tầng 14</option>
                        <option value="15">tầng 15</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Loại Văn Phòng:</td>
                <td>
                    <select name="loaiVanPhong" title="Chọn danh mục sản phẩm">
                        <option value="Van phong">Văn phòng</option>
                        <option value="Van phong chia se">Văn phòng chia sẽ</option>
                        <option value="Van phong tron goi">Văn phòng trọn gói</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Giá:</td>
                <td>
                    <input type="number" step="any" min="1000000" name="gia" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Ngày bắt đầu:</td>
                <td>
                    <input type="date" name="ngayBatDau" class="form-control" required>
                </td>
            </tr>

            <tr>
                <td>Ngày kết thúc:</td>
                <td>
                    <input type="date" name="ngayKetThuc" class="form-control" required>
                </td>
            </tr>


            <tr>
                <td colspan="2" align="center">
                    <a href="/matBang?action="><input type="button" value="Done"></a>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
