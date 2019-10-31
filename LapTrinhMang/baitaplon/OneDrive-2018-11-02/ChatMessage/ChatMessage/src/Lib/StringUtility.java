/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author AdamKyle
 */
public class StringUtility {
    public static final String LOGIN_SUCCESS = "Login success";
    public static final String SERVER_NO_CONNECT = "No connect to server";
    public static final short FUNCTION_CLIENT_SENT_MESS = 1;
    public static final short FUNCTION_CLIENT_GET_LIST_FRIENDS = 2;
    public static final short FUNCTION_CLIENT_GET_MESS_BY_USERID = 3;
    public static final short FUNCTION_CLIENT_GET_GROUP_BY_USERID = 4;
    public static final String RECEIVE = "Receive";
    public static final String SEND = "Send";
    public static final String currentDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }
}
