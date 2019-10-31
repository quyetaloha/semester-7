<%-- 
    Document   : index
    Created on : Aug 20, 2016, 10:06:12 AM
    Author     : Lonely
--%>


<%@page import="com.examp.giaima.SanPhamDAO"%>
<%@page import="com.examp.giaima.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Book Information</title>
    </head>
    <body>
        <% ArrayList<SanPham> lst = new SanPhamDAO().getAllProducts(); %>
       
        <h1 align="center">List Book</h1>
        <table border="1" width="80%" align="center">
            <tr>
                <th>Book's ID</th>
                <th>Book's Name</th>
                <th>Provider</th>
                <th>Unit's Price</th>
                <th colspan="2"><a href="insert.jsp">Insert New</a></th>
            </tr>
            <%
                for (SanPham sp : lst) {
                    String editURL = "update.jsp?id=" + sp.getID();
                    String deleteURL = "DeleteServlet?id=" + sp.getID();
            %>
            <tr>
                <td><%= sp.getID() %></td>
                <td><%=sp.getName()%></td>
                <td><%=sp.getCompany()%></td>
                <td><%=sp.getPrice()%></td>
                
                <td><a href="<%=editURL%>">Update</a></td>
                <td><a href="<%=deleteURL%>">Delete</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>