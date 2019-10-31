<%-- 
    Document   : update
    Created on : Aug 21, 2016, 8:22:59 PM
    Author     : Lonely
--%>
<%@page import="com.examp.giaima.SanPhamDAO"%>
<%@page import="com.examp.giaima.SanPham"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            SanPham sp = new SanPhamDAO().getSanPhamID(id);
        %>
        <form action="UpdateServlet" method="POST">
            <h1>Update Book</h1>
            <table>
                <tr>
                    <td>Book's ID</td>
                    <td><input type="text" name="id" value="<%=sp.getID()%>" readonly></td>
                </tr>
                <tr>
                    <td>Book's Name</td>
                    <td><input type="text" name="name" value="<%=sp.getName()%>"></td>
                </tr>
                <tr>
                    <td>Provider</td>
                    <td><input type="text" name="company" value="<%=sp.getCompany()%>"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="<%=sp.getPrice()%>"></td>
                </tr>
                <tr>

                    <td colspan="2" align="right">
                        <button type="submit" name="Update">Insert</button>
                        <button type="reset" name="reset">Reset</button>
                    </td>
                </tr>
                
                </table>
        </form>
    </body>
</html>
