/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmessage.DAO;

import com.mysql.jdbc.Connection;

/**
 *
 * @author AdamKyle
 */
public interface baseDAO {
    public abstract Connection getConnection();
}
