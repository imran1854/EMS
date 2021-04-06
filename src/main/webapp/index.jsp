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
    <h2>Login Form</h2>
    <br>
    <form action="/Login" inp>
        <input type="hidden" name="command" value="login">
    Username : <input type="text" name="txtusername" required>
    <br><br>
    Password : <input type="password" name="txtpassword" required>
    <br><br>
    <input type="submit" value="Login"> <a href="/signup.jsp">Sign up</a>
    </form>
</div>

</body>
</html>