/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examp.giaima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author DUCTHANH
 */
public class AccountDAO {

    public AccountDAO() {
    }
    public boolean insertac(Account ac) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        ArrayList<Account> list = new ArrayList();
        
        File file=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\ac.txt");
        String user,pass;
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()){
             user = br.readLine();
             pass=br.readLine();
             
             Account sp=new Account(user,pass);
             list.add(sp);
         }
        for(int i=0;i<list.size();i++)
            if(ac.getUsername().equalsIgnoreCase(list.get(i).getUsername()))
                return false;
        
        File file2=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\ac.txt");
        try (PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file2,true))) ){
              
              pw.println(ac.getUsername());
              pw.println(ac.getPass());
            
            
        } catch (Exception e) {
        }
       
        
        return true;
    }
    
    public boolean checkLogin(Account ac) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        File file=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\ac.txt");
        String user,pass;
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()){
             user = br.readLine();
             pass=br.readLine();
             
             Account sp=new Account(user,pass);
             if(sp.getUsername().equals(ac.getUsername())&&sp.getPass().equals(ac.getPass()))
                 return true;
             
         }
        
        return false;
    }
}
