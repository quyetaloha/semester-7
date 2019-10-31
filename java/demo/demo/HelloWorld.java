
package demo;


public class HelloWorld {
    public static int sumA(int[] a){
        int re=0;
        //for(int i=0;i<a.length;i++)
          //  re+=a[i]
        for(int i:a)
            re+=i;
        return re;
    }
    public static double sumDouble(double... a){
        double re=0;
        //for(int i=0;i<a.length;i++)
          //  re+=a[i]
        for(double i:a)
            re+=i;
        return re;
    }
    public static int agvA(int... a){
        int re=0;
        for(int i:a)
            re+=i;
        re=re/(a.length);
        return re;
    }
    public static double[][] add(double[][] a,double[][]b){
        double[][]t;
        t=new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                t[i][j]=a[i][j]+b[i][j];
        return t;
    }
    public static String pt(double[][] a){
        String re="";
        
        System.out.println("Aray:"+a);
        return re;
    }
    public static void main(String[] args) {
        int year=22,mark;
        double x=12.4;
        float h,i,n;
        h=4.6f;
        char an='v';
        int d=2,a=2,b=2;
        String name="hh nn";
        int u=(int)x;
        x=h;
        int[]k={3,4,5};
        int[] ll;
        ll=new int[5];
        int[][]ans;
        ans=new int[2][5];
        ans[0][2]=7;
        System.out.println("\"Hello World!!!!!\" said ");
        System.out.println("Year: "+year);
        System.out.println("X: "+6+6);
        System.out.println("3|4: "+(3|4));
        System.out.println("2>>4: "+(2>>4));
        System.out.println("a ="+a+2);
        System.out.println("b ="+(b+2));
        System.out.println("Sum:"+sumA(k));
        System.out.println("Average: "+agvA(2,4,5));
        System.out.println("Sum of double:"+
                sumDouble(34.7,7,9,9.5));
        System.out.println("\n\n\n");
        System.out.println("Row= "+ans.length);
        System.out.println("Column= "+ans[0].length);
        //mang 2 chieu
        System.out.println("\n\n\n");
        double[][] q={{4.6,7},{7,4}};
        double[][] p={{6,2},{8.2,0}};
        double[][] mm;
        mm=add(p,q);
        pt(add(q,p));
        String[] names={"lan tu","hhh hh","nnn mmm"};
        for(String s:names)
          System.out.println(s);
        Integer y = 567; // make a wrapper 
Integer yy = new Integer(567);
Integer xx = yy; //assign a second ref 
        // var to THE wrapper
System.out.println("\n\n\n");
  System.out.println(yy==xx); 
  yy++; // unwrap, use, "rewrap" 
  System.out.print(xx + " " + yy); 
  System.out.print(yy==xx);
  Integer cc=345;// new Integer(456);//new Integer("456");
    }
}
