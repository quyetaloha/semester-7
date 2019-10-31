<%-- 
    Document   : login
    Created on : Sep 3, 2018, 11:53:23 AM
    Author     : DUCTHANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet" method="POST">
        <h1 align = "center">Login Form</h1>
        <table align="center">
            <tr>
                <td>User Name</td>
                <td><input type="text" name="user" autocomplete="off"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass" autocomplete="off"></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button type="submit" name="Login">Login</button>
                    <input type="button" value="Register"  onclick="location.href='reg.jsp'">
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
