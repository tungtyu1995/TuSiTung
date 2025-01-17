<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/6/2020
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS, Popper.js, and jQuery -->
    <%--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    <style>
        body {
            color: #566787;
            background: #f7f5f2;
            font-family: 'Roboto', sans-serif;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0,0,0,.05);
        }
        .table-title {
            color: #fff;
            background: #40b2cd;
            padding: 16px 25px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .search-box {
            position: relative;
            float: right;
        }
        .search-box .input-group {
            min-width: 300px;
            position: absolute;
            right: 0;
        }
        .search-box .input-group-addon, .search-box input {
            border-color: #ddd;
            border-radius: 0;
        }
        .search-box input {
            height: 34px;
            padding-right: 35px;
            background: #f4fcfd;
            border: none;
            border-radius: 2px !important;
        }
        .search-box input:focus {
            background: #fff;
        }
        .search-box input::placeholder {
            font-style: italic;
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 6px 0;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
            position: relative;
            top: 2px;
        }
        table.table {
            table-layout: fixed;
            margin-top: 15px;
        }
        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table th:first-child {
            width: 60px;
        }
        table.table th:last-child {
            width: 120px;
        }
        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }
        table.table td a.view {
            color: #03A9F4;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #E34724;
        }
        table.table td i {
            font-size: 19px;
        }
        table.table td i {
            font-size: 19px;
        }
        a {
            color: seashell;
            text-decoration: none;
            background-color: transparent;
        }
    </style>
</head>
<body style="background-image: url('https://www.travelvietnam.com/images/photos/asia/vietnam-danang-furama-resort-danang-3.jpg?t=1594914357')">
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/customerServlet?action=edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Customer</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <c:if test="${customer != null}">
                    <input type="hidden" name="id" value="<c:out value='${customer.id}'></c:out>" required>
                </c:if>
                <div class="modal-body">

                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" name="name" required value="<c:out value='${customer.name}'></c:out>" required>
                    </div>

                    <div class="form-group">
                        <label>Birthday</label>
                        <input type="date" name="birthday" class="form-control" value="<c:out value='${customer.birthday}'></c:out>" required>
                    </div>

                    <div class="form-group">
                        <label>ID Card Number</label>
                        <input type="number" min="100000000" max="999999999" name="idCard" class="form-control" value="<c:out value='${customer.idCard}'></c:out>" required>
                    </div>

                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="number" pattern="(09|01[2|6|8|9])+([0-9]{8})\b" name="phoneNumber" class="form-control" value="<c:out value='${customer.phoneNumber}'></c:out>" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" value="<c:out value='${customer.email}'></c:out>" required>
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" name="address" class="form-control" value="<c:out value='${customer.address}'></c:out>" required>
                    </div>

                    <div class="form-group">
                        <label>Customer Type</label>
                        <select name="idCustomerType" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="customerType" items="${customerTypeList}">
                                <option value="${customerType.id}"><c:out value="${customerType.nameCustomerType}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <a href="/customerServlet"><input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"></a>
                    <input type="submit" class="btn btn-success" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
