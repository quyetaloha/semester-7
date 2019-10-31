/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.userLogin;
/**
 *
 * @author AdamKyle
 */
public class test {
    public static void main(String[] args) {
        try {
            Connection con = conn.ketnoi();
            StringBuilder query = new StringBuilder();
            query.append("select * from userlogin");
            PreparedStatement ps = null;
            ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            List<userLogin> dslogin = new ArrayList<userLogin>();
            while(rs.next()){
                userLogin a = new userLogin(rs.getInt("id"), rs.getString("username"), rs.getString("pass"));
                dslogin.add(a);
            }
            System.out.println("get data combo success "+dslogin.size());
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
