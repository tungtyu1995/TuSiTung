<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/7/2020
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    .menu ul li{
        margin-right: 10%;
    }
</style>
<script>
    $(document).ready(function(){
        // Activate tooltips
        $('[data-toggle="tooltip"]').tooltip();
        // Filter table rows based on searched term
        $("#search").on("keyup", function() {
            var term = $(this).val().toLowerCase();
            $("table tbody tr").each(function(){
                $row = $(this);
                var name = $row.find("td:nth-child(2)").text().toLowerCase();
                console.log(name);
                if(name.search(term) < 0){
                    $row.hide();
                } else{
                    $row.show();
                }
            });
        });
    });
</script>
<script type="text/javascript">
    $(function () {
        var pageSize = 7; // Hiển thị 7 sản phẩm trên 1 trang (nghĩa là 7 rows)
        showPage = function (page) {
            $(".contentPage").hide();
            $(".contentPage").each(function (n) {
                if (n >= pageSize * (page - 1) && n < pageSize * page)
                    $(this).show();
            });
        }
        showPage(1);
        ///** Cần truyền giá trị vào đây **///
        var totalRows = ${count}; // Tổng số sản phẩm hiển thị
        var btnPage = 5; // Số nút bấm hiển thị di chuyển trang
        var iTotalPages = Math.ceil(totalRows / pageSize);
        var obj = $('#pagination').twbsPagination({
            totalPages: iTotalPages,
            visiblePages: btnPage,
            onPageClick: function (event, page) {
                console.info(page);
                showPage(page);
            }
        });
        console.info(obj.data());
    });
</script>
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
<div class="header">
    <div class="container-fluid">
        <div class="row" >
            <div class="col-3">
                <img style="width: 30%;padding: 15px" src="https://phuongviethcm.com/wp-content/uploads/2019/07/FURAMA.png">
            </div>
            <div class="col-3"></div>
            <div class="col-3"></div>
            <div class="col-3" style="display: flex;align-items: center">
                <h3 style="color: white">Từ Sĩ Tùng</h3>
            </div>
        </div>
    </div>
</div>
<!--end header-->
<div class="menu" style="background-color: sienna;height: 50px">
    <div class="container">
        <div class="row">
            <div class="col-12" >
                <ul style="list-style: none;display:flex;flex-direction: row;padding-top: 12px">
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="/employeeServlet">Employee</a></li>
                    <li><a href="/customerServlet">Customer</a></li>
                    <li>  <a href="/serviceServlet">Service</a></li>
                    <li><a href="/contractServlet">Contract</a></li>
                    <li class="input-group" style="margin: -6px">
                        <input type="text" id="search" class="form-control" placeholder="Search by Name">
                    </li>
                    <!--                <li><input type="submit" value="Search"></li>-->
                </ul>
            </div>
        </div>
    </div>
</div>
<!--end menu-->


<%--addCustomerModal--%>
<div >
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/contractServlet" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add New Contract</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label>Start Date</label>
                        <input  type="date" class="form-control" name="startDate" required>
                    </div>

                    <div class="form-group">
                        <label>End Date</label>
                        <input type="date" name="endDate" class="form-control" required></input>
                    </div>

                    <div class="form-group">
                        <label>Deposit</label>
                        <input type="number" step="any" min="1.0" title="Nhập vào tiền đặt cọc" name="deposit" class="form-control" required></input>
                    </div>

                    <div class="form-group">
                        <label>Total Money</label>
                        <input type="number" step="any" min="1.0" title="Nhập vào tổng tiền" name="totalMoney" class="form-control" required></input>
                    </div>
                    <div class="form-group">
                        <label>Name of Employee</label>
                        <select name="idEmployee" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="employee" items="${employeeList}">
                                <option value="${employee.id}"><c:out value="${employee.name}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Name of Customer</label>
                        <select name="idCustomer" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="customer" items="${customerList}">
                                <option value="${customer.id}"><c:out value="${customer.name}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Name of Service</label>
                        <select name="idService" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="service" items="${serviceList}">
                                <option value="${service.id}"><c:out value="${service.name}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>

                </div>

                <div class="modal-footer">
                    <a href="/home.jsp"><input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"></a>
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<%--End - addContractModal--%>
<!-- Edit Modal HTML -->

</body>
</html>
