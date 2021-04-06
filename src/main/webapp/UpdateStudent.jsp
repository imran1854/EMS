<%--
  Created by IntelliJ IDEA.
  User: Arshman
  Date: 4/3/2021
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
    <style>
        form {
            margin-top: 10px;
        }

        label {
            font-size: 16px;
            width: 100px;
            display: block;
            text-align: right;
            margin-right: 10px;
            margin-top: 8px;
            margin-bottom: 8px;
        }

        input {
            width: 250px;
            border: 1px solid #666;
            border-radius: 5px;
            padding: 4px;
            font-size: 16px;
        }

        .save {
            font-weight: bold;
            width: 130px;
            padding: 5px 10px;
            margin-top: 30px;
            background: #cccccc;
        }

        table {
            border-style:none;
            width:50%;
        }

        tr:nth-child(even) {background: #FFFFFF}
        tr:nth-child(odd) {background: #FFFFFF}

        tr {
            border-style:none;
            text-align:left;
        }



        #wrapper {width: 100%; margin-top: 0px; }
        #header {width: 72%; background: #0775d3; margin-top: 0px; padding:15px 0px 15px 0px;}
        #header h2 {width: 100%; margin:auto; color: #FFFFFF;}
        #container {width: 100%; margin:auto}
        #container h3 {color: #000;}
        #container #content {margin-top: 20px;}

        .add-student-button {
            border: 1px solid #666;
            border-radius: 5px;
            padding: 4px;
            font-size: 12px;
            font-weight: bold;
            width: 120px;
            padding: 5px 10px;

            margin-bottom: 15px;
            background: #cccccc;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Update Employee</h2>
    </div>
</div>
<form action="getEmployees" method="get">
    <input type="hidden" name="command" value="UPDATE">
    <input type="hidden" name="student_id" value="${THE_STUDENT.id}">
<table>
    <tr>
        <td><label>First Name:</label></td>
        <td><input type="text" name="fname" value="${THE_STUDENT.firstName}"></td>
    </tr>
    <tr>
        <td><label>Last Name:</label></td>
        <td><input type="text" name="lname" value="${THE_STUDENT.lastName}"></td>
    </tr>
    <tr>
        <td><label>Email:</label></td>
        <td><input type="text" name="email" value="${THE_STUDENT.email}"></td>
    </tr>
    <tr>
        <td><label>Status:</label></td>
        <td><input type="checkbox" name="status" value="${THE_STUDENT.status}"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" class="save"></td>
    </tr>
</table>
</form>
<div style="clear: both"></div>
<p>
    <a href="getEmployees">Back to List</a>
</p>
</body>
</html>
