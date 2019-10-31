<%-- 
    Document   : reg
    Created on : Sep 3, 2018, 11:00:07 PM
    Author     : DUCTHANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form action="RegisterServlet" method="POST">
        <h1 align = "center">Register Form</h1>
        <table align="center">
            <tr>
                <td>User Name</td>
                <td><input type="text" name="user" autocomplete="on"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass" autocomplete="off"></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button type="submit" name="Register">Register</button>
                    
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
