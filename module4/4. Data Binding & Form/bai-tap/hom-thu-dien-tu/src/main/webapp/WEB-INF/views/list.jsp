<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2020
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<a href="/email/create">Add New Email</a>
<h3>List Email</h3>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <th>Id</th>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    <c:forEach var="email" items="${emails}">
        <tr>
            <td>${email.id}</td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td>
                <a href="/email/delete/${email.id}">Delete</a>
                <a href="/email/edit/${email.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
