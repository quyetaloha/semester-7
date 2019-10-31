
package demo;
import java.util.Scanner;

public class WrapperDemo {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Max:"+Integer.MAX_VALUE);
        System.out.println("Min:"+Integer.MIN_VALUE);
        Integer x=new Integer(34);
        Integer y=new Integer(89);
        System.out.println("Compare: "+x.compareTo(y));
        System.out.println("Compare:"+Integer.compare(x, y));
        int year;
        String name;
        double mark;
        String address;
        System.out.print("name:");
        name=in.nextLine();
        System.out.print("Year:");
        year=in.nextInt();
        in.nextLine();
        System.out.println("Address:");
        address=in.nextLine();
        System.out.println("Mark:");
        mark=in.nextDouble();
        System.out.println("name:"+name+"year"+year+
                "address"+address+"Mark:"+mark);
        System.out.println(Character.toString('v'));
        Character c='v';
        System.out.println(c.toString());
        System.out.println("Ly Lao Lo".substring(2,5));
        String name1="To anh khanh hoa";
        System.out.println(name1.substring(name1.trim().
                lastIndexOf(" ")+1));
        String st="Example   method   Split    "
                + "a Line into         Words";
        String[] s=st.split("\\s+");
        String mg="";
        for(String i:s)
            mg+=i+" ";
        st.replaceAll("\\s+"," ");
        System.out.println(mg);
    }    
}
