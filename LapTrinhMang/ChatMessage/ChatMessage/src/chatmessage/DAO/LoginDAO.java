/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmessage.DAO;

import chatmessage.orm.Users;

/**
 *
 * @author AdamKyle
 */
public interface LoginDAO extends baseDAO{
    public Users selectUser(String username, String passWord);
}
