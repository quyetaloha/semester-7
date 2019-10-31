
package demo;

import java.util.Scanner;
public class ExString {
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //xu ly kieam tra nhap lieu
        ReEx r=new ReEx();
        //chuan hoa doan
        Paragraph p=new Paragraph();
        String p1="(543)-654-9874";
        String p2="5436549874";
        String p3="43)-54-9874";
        String c1="B16DCCN765";
        String c2="B1CCN765";
        String code;
        System.out.println(r.isPhoneValid(p1));
        System.out.println(r.isPhoneValid(p2));
        System.out.println(r.isPhoneValid(p3));
        System.out.println(r.isCode(c1));
        System.out.println(r.isCode(c2));
        //nhap ma dung
        while(true){
            System.out.print("Code:");
            code=in.nextLine();
            if(r.isCode(code))
                break;
        }
        //nhap date
        String d;
        while(true){
            System.out.print("Date:");
            d=in.nextLine();
            if(r.isDate(d))
                break;
        }
        System.out.println("Code:"+code+" Date:"+d);
        String line="We    were   both   young ,   "
            + "when   I first saw you .  i    "
            + "close my eyes and the flashback starts";
        System.out.println(p.normalText(line));        
    }
    
}
