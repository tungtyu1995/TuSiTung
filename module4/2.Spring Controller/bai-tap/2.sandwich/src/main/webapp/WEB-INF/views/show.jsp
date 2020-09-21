<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2020
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form method="post" action="/save">
    <p>
        <input type="checkbox" name="condiment" value="Lettuce" checked>Lettuce</input>
        <input type="checkbox" name="condiment" value="Tomato">Tomato</input>
        <input type="checkbox" name="condiment" value="Mustard">Mustard</input>
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts</input>
    </p>
    <input type="submit" name="submit" value="Save">
    <hr>
    <h2>Condiment List</h2>

    <c:forEach var="condiment" items="${condiment}">
        <c:out value="${condimentondiment}"></c:out> <br>
    </c:forEach>

    <c:out value="${msg}"/>

</form>


</body>
</html>
