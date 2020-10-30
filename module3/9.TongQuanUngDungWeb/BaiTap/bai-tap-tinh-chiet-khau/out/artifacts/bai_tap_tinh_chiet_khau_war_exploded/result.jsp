<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/26/2020
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reasult</title>
</head>
<body>
<h1> Product Description: <%=request.getParameter("productDescription")%></h1>
<h1> List Price: <%=request.getParameter("listPrice")%> </h1>
<h1> Discount Percent: <%=request.getParameter("discountPercent")%> </h1>
<h1> Discount Amount: <%=request.getAttribute("discountAmount")%> </h1>
<h1> Discount Price: <%=request.getAttribute("discountPrice")%> </h1>
</body>
</html>
