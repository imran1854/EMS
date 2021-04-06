<%--
  Created by IntelliJ IDEA.
  User: Arshman
  Date: 4/2/2021
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>employee Details</title>
    <style>
        html, body{
            margin-left:15px; margin-right:15px;
            padding:0px;
            font-family:Verdana, Arial, Helvetica, sans-serif;
        }

        table {
            border-collapse:collapse;
            border-bottom:1px solid gray;
            font-family: Tahoma,Verdana,Segoe,sans-serif;
            width:72%;
        }

        th {
            border-bottom:1px solid gray;
            background:none repeat scroll 0 0 #0775d3;
            padding:10px;
            color: #FFFFFF;
        }

        tr {
            border-top:1px solid gray;
            text-align:center;
        }

        tr:nth-child(even) {background: #FFFFFF}
        tr:nth-child(odd) {background: #BBBBBB}

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

    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Employee Detail</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Employee" onclick="window.location.href='AddStudent.jsp'; return false;"
        class="add-student-button">

<table border="1">
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Status</th>
    <th>Action</th>

<c:forEach var="tempEmp" items="${Emp_list}">
    <%--Set up link for each student--%>
    <c:url var="templink" value="getEmployees">
        <c:param name="command" value="LOAD"></c:param>
        <c:param name="empid" value="${tempEmp.id}"></c:param>
    </c:url>
    <c:url var="deletelink" value="getEmployees">
        <c:param name="command" value="DELETE"></c:param>
        <c:param name="deleteID" value="${tempEmp.id}"></c:param>
    </c:url>
    <tr>
        <td>
                ${tempEmp.id}
        </td>
        <td>
                ${tempEmp.firstName}
        </td>
        <td>
                ${tempEmp.lastName}
        </td>
        <td>
                ${tempEmp.email}
        </td>
        <td>
                ${tempEmp.status}
        </td>
        <td>
            <a href="${templink}">Update</a>
            |
            <a href="${deletelink}" onclick="if (!(confirm('Are you sure to delete this Employee?'))) return false">Delete</a>
        </td>
    </tr>

</c:forEach>
</table>
    </div>
</div>
</body>
</html>
