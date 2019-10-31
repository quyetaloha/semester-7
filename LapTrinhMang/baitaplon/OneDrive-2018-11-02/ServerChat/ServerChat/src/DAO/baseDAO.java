/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Connect;
import com.mysql.jdbc.Connection;

/**
 *
 * @author AdamKyle
 */
public interface baseDAO {
    public Connection con = Connect.ketnoi();
}
