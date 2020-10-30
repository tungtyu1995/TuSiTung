<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/27/2020
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculatorServletPath" method="get">
  <fieldset style="width: 300px">
    <legend>Calculator</legend>
    <table style="text-align: left">
      <tr>
        <th>First Operand:</th>
        <th><input type="text" name="FirstOperand"></th>
      </tr>
      <tr>
        <th>Operator:</th>
        <th><select name="Operator">
          <option value="+">Addition</option>
          <option value="-">Subtraction</option>
          <option value="*">Multiplication</option>
          <option value="/">Division</option>
        </select>
        </th>
      </tr>
      <tr>
        <th>Second Operand:</th>
        <th><input type="text" name="SecondOperand"></th>
      </tr>
      <tr>
        <th></th>
        <th><input type="submit" value="calculate"></th>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>