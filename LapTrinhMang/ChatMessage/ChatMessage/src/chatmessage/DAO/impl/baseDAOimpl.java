/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmessage.DAO.impl;

import chatmessage.Bean.Connect;
import chatmessage.DAO.baseDAO;
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
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/laptrinhmang", "root", "gom8kitu");
            
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        System.out.println("connected");
        }
        return con;
    }
}
