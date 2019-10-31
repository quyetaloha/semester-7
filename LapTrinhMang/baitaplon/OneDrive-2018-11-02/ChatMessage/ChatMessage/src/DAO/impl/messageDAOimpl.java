/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.impl;

import Bean.baseBean;
import DAO.messageDAO;
import orm.Message;
import orm.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AdamKyle
 */
public class messageDAOimpl extends baseDAOimpl implements messageDAO{
    public List<Message> selectMessagesByFromUserId(int fromUserId){
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ul.* from users ul,friendList fl ");
            query.append("where fl.userId = ");
            query.append("and ul.usersId = fl.userFriendId ");
            PreparedStatement ps = null;
            ps = baseBean.con.prepareStatement(query.toString());
            List<Users> listFriends = new ArrayList<Users>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Users userFriend = new Users();
                userFriend.setUserId(rs.getInt("UsersId"));
                userFriend.setUserName(rs.getString("UserName"));
                userFriend.setPassWord(rs.getString("PassWord"));
                userFriend.setState(rs.getInt("State"));
                userFriend.setFirstName(rs.getString("FirstName"));
                userFriend.setLastName(rs.getString("LastName"));
                userFriend.setEmail(rs.getString("Email"));
                userFriend.setAddress(rs.getString("Address"));
                listFriends.add(userFriend);
            }
            ps.close();
            System.out.println("select friends size = "+listFriends.size());
            //return listFriends;
        } catch (SQLException ex) {
            
        }
        return new ArrayList<>();
    }
}
