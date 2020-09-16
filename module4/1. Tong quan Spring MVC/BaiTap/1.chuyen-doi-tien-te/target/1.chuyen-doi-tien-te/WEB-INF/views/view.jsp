<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/16/2020
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển Đổi Tiền Tệ</title>
</head>
<body>
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <h4 class="modal-title">Chuyển Đổi Tiền Tệ</h4>

                <form method="post" action="/view">

                    <div class="form-group">
                        <label>Tỉ giá:</label>
                        <input name="exchangeRate" value="20000" class="form-control" readonly>
                    </div>

                    <div class="form-group">
                        <label>USD::</label>
                        <input type="number" step="any" min="0,1" name="usd" value="${usd}" class="form-control"
                               required>
                    </div>

                    <div class="form-group">
                        <label>VND:</label>
                        <input type="text" name="vnd" value="${vnd}" class="form-control" readonly>
                    </div>

                    <div>
                        <input type="submit" class="btn btn-success" value="Done"/>
                        <form method="get">
                            <a href="/view"><input type="button" class="btn btn-default" value="Reset"/></a>
                        </form>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>
