/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.impl;

import DAO.UsersDAO;
import DAO.baseDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import orm.Users;

/**
 *
 * @author AdamKyle
 */
public class UsersDAOimpl extends UsersDAO{
    public UsersDAOimpl() {
        
    }
    
    public Users checkLogin(String user, String pass){
        try {
            StringBuilder query = new StringBuilder();
            query.append("select * from users ul ");
            query.append("where ul.username = '"+user+"' ");
            query.append("and ul.password = '"+pass+"' ");
            query.append("limit 1");
            PreparedStatement ps = null;
            ps = baseDAO.con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            Users result = null ;
            if(rs.next()){
                result = new Users();
                result.setUserId(rs.getInt("UsersId"));
                result.setUserName(rs.getString("UserName"));
                result.setPassWord(rs.getString("PassWord"));
                result.setState(rs.getInt("State"));
                result.setFirstName(rs.getString("FirstName"));
                result.setLastName(rs.getString("LastName"));
                result.setEmail(rs.getString("Email"));
                result.setAddress(rs.getString("Address"));
            }
            ps.close();
            if(result != null){
                return result;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
