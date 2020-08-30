<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/28/2020
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head><body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].productName}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].productPrice}"></td>
            </tr>
            <tr>
                <td>Describe: </td>
                <td><input type="text" name="describe" id="describe" value="${requestScope["product"].productDescribe}"></td>
            </tr>
            <tr>
                <td>Madeby: </td>
                <td><input type="text" name="ProductBy" id="ProductBy" value="${requestScope["product"].productBy}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>