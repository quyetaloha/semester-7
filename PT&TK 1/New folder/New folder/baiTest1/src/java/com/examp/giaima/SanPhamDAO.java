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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lonely
 */
public class SanPhamDAO {

 

    public SanPhamDAO() {
        
    }

    public ArrayList<SanPham> getAllProducts() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        ArrayList<SanPham> list = new ArrayList();
        File file=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
        String id,name,nxb,price;
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()){
             id = br.readLine();
             name=br.readLine();
             nxb=br.readLine();
             price=br.readLine();
             SanPham sp=new SanPham(id, name, nxb, price);
             list.add(sp);
         }
        
        
        return list;
    }

    public boolean insertNew(SanPham sp) throws SQLException, UnsupportedEncodingException, IOException {
        ArrayList<SanPham> list = getAllProducts();
        for(int i=0;i<list.size();i++)
            if(sp.getID().equalsIgnoreCase(list.get(i).getID()))
                return false;
        
        File file2=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
        try (PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file2,true))) ){
              
              pw.println(sp.getID());
              pw.println(sp.getName());
              pw.println(sp.getCompany());
              pw.println(sp.getPrice());
            
        } catch (Exception e) {
        }
        return true;
    }

    public boolean updateOld(SanPham spp) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
       
        ArrayList<SanPham> list = new ArrayList();
        File file=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
        String id,name,nxb,price;
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()){
             id = br.readLine();
             name=br.readLine();
             nxb=br.readLine();
             price=br.readLine();
             SanPham sp2=new SanPham(id, name, nxb, price);
             if(sp2.getID().equalsIgnoreCase(spp.getID())){
                 list.add(spp);
             }
             else{
                 list.add(sp2);
             }
             
         }
        
        File file2=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
       
        try (PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file2,false))) ){
              
              pw.println(list.get(0).getID());
              pw.println(list.get(0).getName());
              pw.println(list.get(0).getCompany());
              pw.println(list.get(0).getPrice());
            
        } catch (Exception e) {
        }
        
        if(list.size()>2){
            File file3=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
            for(int i=1;i<list.size();i++){
            
                 try (PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file3,true))) ){
              
                    pw.println(list.get(i).getID());
                    pw.println(list.get(i).getName());
                    pw.println(list.get(i).getCompany());
                    pw.println(list.get(i).getPrice());
            
                } catch (Exception e) {
                    }
            
            }
        }
        
        return true;
    }

    public boolean delete(String id) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        ArrayList<SanPham> list = new ArrayList();
        File file=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
        String idd,name,nxb,price;
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()){
             idd = br.readLine();
             name=br.readLine();
             nxb=br.readLine();
             price=br.readLine();
             SanPham sp2=new SanPham(idd, name, nxb, price);
             if(!sp2.getID().equalsIgnoreCase(id)){
                 list.add(sp2);
             }
            
             
         }
        
        File file2=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
       
        try (PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file2,false))) ){
              
              pw.println(list.get(0).getID());
              pw.println(list.get(0).getName());
              pw.println(list.get(0).getCompany());
              pw.println(list.get(0).getPrice());
            
        } catch (Exception e) {
        }
        
        if(list.size()>=2){
            File file3=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
            for(int i=1;i<list.size();i++){
            
                 try (PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file3,true))) ){
              
                    pw.println(list.get(i).getID());
                    pw.println(list.get(i).getName());
                    pw.println(list.get(i).getCompany());
                    pw.println(list.get(i).getPrice());
            
                } catch (Exception e) {
                    }
            
            }
        }
        
        return true;
    }

    public SanPham getSanPhamID(String id) throws SQLException, FileNotFoundException, IOException {
        SanPham sp = null;
        File file=new File("C:\\Users\\DUCTHANH\\Downloads\\baiTest1\\baiTest1\\src\\java\\com\\examp\\giaima\\db.txt");
        String idd,name,nxb,price;
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while(br.ready()){
             idd = br.readLine();
             name=br.readLine();
             nxb=br.readLine();
             price=br.readLine();
             SanPham sp2=new SanPham(idd, name, nxb, price);
             if(sp2.getID().equalsIgnoreCase(id)){
                 sp=new SanPham(idd, name, nxb, price);
                 break;
             }
             
         }
        return sp;
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
