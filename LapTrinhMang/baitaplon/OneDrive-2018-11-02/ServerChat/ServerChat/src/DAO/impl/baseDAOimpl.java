/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.impl;

import Bean.Connect;
import DAO.baseDAO;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class baseDAOimpl implements baseDAO{
    static Connection con = null;
    public Connection getConnection(){
        //dang ky driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        //connect
        if(con==null){
            try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "quyetdaik");
            
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        System.out.println("connected");
        }
        return con;
    }
}
