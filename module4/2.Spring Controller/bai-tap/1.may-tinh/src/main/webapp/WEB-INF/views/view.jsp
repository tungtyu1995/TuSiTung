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
    <title>Calculator</title>
</head>
<body>
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form method="post" id="form">
                    <h4 class="modal-title">Calculator</h4>

                    <div class="form-group">
                        <label>Number1:</label>
                        <input type="number" step="any" name="number1" value="${number1}" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Number2:</label>
                        <input type="number" step="any" name="number2" value="${number2}" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Result:</label>
                        <input name="result" value="${result}" class="form-control" readonly>
                    </div>

                    <div class="form-group">
                        <input type="button" class="btn btn-success" value="Addition(+)" onclick="addition()"/>
                        <input type="button" class="btn btn-success" value="Subtraction(-)" onclick="subtraction()"/>

                    </div>

                    <div class="form-group">
                        <input type="button" class="btn btn-success" value="Multiplication(X)"
                               onclick="multiplication()"/>
                        <input type="button" class="btn btn-success" value="Division(/)" onclick="division()"/>
                    </div>

                    <div class="form-group">
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
<script>

    function addition() {
        document.getElementById("form").action = "/addition";
        document.getElementById("form").submit();
    }

    function subtraction() {
        document.getElementById("form").action = "/subtraction";
        document.getElementById("form").submit();
    }

    function multiplication() {
        document.getElementById("form").action = "/multiplication";
        document.getElementById("form").submit();
    }

    function division() {
        document.getElementById("form").action = "/division";
        document.getElementById("form").submit();
    }

</script>
</html>
