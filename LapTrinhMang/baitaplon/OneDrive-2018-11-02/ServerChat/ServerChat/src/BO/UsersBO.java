/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import orm.Users;

/**
 *
 * @author AdamKyle
 */
public interface UsersBO extends BaseBO{
    public Users checkLogin(String user, String pass);
}
