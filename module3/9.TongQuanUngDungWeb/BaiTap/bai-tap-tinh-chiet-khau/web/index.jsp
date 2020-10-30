<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/26/2020
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
    <style>
        .abc {
            height: 180px;
            width: 230px;
            margin: 0;
            padding: 10px;
            border: 1px #CCC solid;
        }

        .abc input {
            padding: 5px;
            margin: 5px
        }
    </style>
</head>
<body>
<h2>Product Discount Calculator</h2>
<form  action="discount" method="post">
    <div class="abc">
        <input type="text" name="productDescription" placeholder="Enter Product Description "/><br>
        <input type="text" name="listPrice" placeholder="Enter List Price"/><br>
        <input type="text" name="discountPercent" placeholder=" Enter Discount Percent"/><br>
        <input type="submit" id="submit" value="Calculate Discount"/>
    </div>
</form>
</body>
</html>

