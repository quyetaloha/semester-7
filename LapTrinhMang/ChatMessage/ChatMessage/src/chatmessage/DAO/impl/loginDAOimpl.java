/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmessage.DAO.impl;

import chatmessage.DAO.LoginDAO;
import chatmessage.orm.Users;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AdamKyle
 */
public class loginDAOimpl extends baseDAOimpl implements LoginDAO{

    @Override
    public Users selectUser(String username, String passWord){
        try {
            Connection conn = getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM users u");
            query.append("WHERE u.userName = "+ username +" ");
            query.append("AND u.passWord ");
            PreparedStatement ps = null;
            ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            List<Users> listUsers = new ArrayList<Users>();
            while(rs.next()){
                Users user = new Users();
                user.setUserId(rs.getInt("UsersId"));
                user.setUserName(rs.getString("UserName"));
                user.setPassWord(rs.getString("PassWord"));
                user.setState(1);
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                listUsers.add(user);
            }
            System.out.println("get data combo success "+listUsers.size());
            ps.close();
            return listUsers.get(0);                  
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
