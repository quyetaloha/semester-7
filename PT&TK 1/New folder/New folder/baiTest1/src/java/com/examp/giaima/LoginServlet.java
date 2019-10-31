/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examp.giaima;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DUCTHANH
 */
public class LoginServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        Account ac=new Account(user, pass);
        AccountDAO acdao=new AccountDAO();
        if(acdao.checkLogin(ac)){
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }
}
