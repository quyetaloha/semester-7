/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Exception1 {
    public static void main(String[] args) {
    String sNum = "CTB";
    String sDate = "10/03/2016";
    try{
    int num = Integer.parseInt(sNum);
    }catch(Exception e){
        System.out.println("Error:"+e);
    }
    try{
       SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
       Date d = f.parse(sDate); 
        System.out.println(d);
    }catch(ParseException e){
        System.out.println(e);
    }
    }

}
