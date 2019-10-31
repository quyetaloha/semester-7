package control;

import java.util.StringTokenizer;

public class ThucThi {

    public String daoXau(String strInput) {
        String strOutput = new StringBuffer(strInput).reverse().toString();
        return strOutput;
    }

    public String chuanHoaInHoa(String strInput) {
        String s, strOutput;
        strInput = strInput.toLowerCase();
        s = strInput.substring(0, 1);
        strOutput = strInput.replaceFirst(s, s.toUpperCase());
        return strOutput;
    }

    public String chuanHoa(String strInput) {
        String strOutput = "";
        StringTokenizer strToken = new StringTokenizer(strInput, " ,\t,\r");
        strOutput += chuanHoaInHoa(strToken.nextToken());
        while (strToken.hasMoreTokens()) {
            strOutput += " " + chuanHoaInHoa(strToken.nextToken());
        }
        return (strOutput);
    }

    public int timMax(int[] x) {
        int max = x[0];
        for (int i = 0; i < x.length; i++) {
            if (max <= i) {
                max = i;
            }
        }
        return max;
    }

    public int USCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return USCLN(b, a % b);
    }

    public int BSCNN(int a, int b) {
        return a * b / USCLN(a, b);
    }

    public int soLanXauConTrongXauMe(String xauCon, String xauMe) {
        int dem = 0;
        for (int i = 0; i < xauMe.length() - xauCon.length(); i++) {
            String str = xauMe.substring(i, i + xauCon.length());
            if (str.equals(xauCon)) {
                dem++;
            }
        }
        String str =xauMe.substring(xauMe.length()-xauCon.length());
        if(str.equals(xauCon)){
            dem++;
        }
        return dem;

    }
    
    public static void main(String[] args) {
        ThucThi thucThi = new ThucThi();
        String xauMe = "xnjakdajlfjaxnklaxnxnxx";
        String xauCOn = "x";
        System.out.println(thucThi.soLanXauConTrongXauMe(xauCOn, xauMe));
    }
}
