<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2020
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="POST" action="/email/create" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="id">ID: </form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td><form:label path="languages">languages:</form:label></td>
            <td><form:select path="languages" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${listPageSize}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter" value="Enable"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"/></td>
            <td><button type="button"/>
                <a href="/email">Cancel</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>
