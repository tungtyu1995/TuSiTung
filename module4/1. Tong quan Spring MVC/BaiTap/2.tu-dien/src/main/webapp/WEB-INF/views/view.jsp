<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/16/2020
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ Điển</title>
</head>
<body>
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form action="/view" method="post">
                    <h4 class="modal-title">Dictionary</h4>

                    <div class="form-group">
                        <label>English:</label>
                        <input type="text" name="word" value="${english}" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Vietnamese::</label>
                        <input value="${vietnamese}" class="form-control" readonly>
                    </div>

                    <div>
                        <input type="submit" class="btn btn-success" value="Search"/>
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
