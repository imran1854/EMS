<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
</head>
<body>
<h1 align="center">Employee Management System</h1>
<div align="center">
    <br>
    <h2>Sign up Form</h2>
    <form action="/Login">
    <input type="hidden" name="command" value="signup">
    <br>
    Full Name :  <input type="text" name="txtname">
    <br><br>
    Contact No : <input type="text" name="txtcontact">
    <br><br>
    Username :   <input type="text" name="txtusername">
    <br><br>
    Password :   <input type="password" name="txtpassword">
    <br><br>
    <input type="submit" value="Signup"> <a href="/index.jsp">Login Form</a>
    </form>
</div>

</body>
</html>