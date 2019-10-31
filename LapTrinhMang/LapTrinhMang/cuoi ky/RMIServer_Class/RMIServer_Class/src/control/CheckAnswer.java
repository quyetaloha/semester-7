/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.StringTokenizer;

/**
 *
 * @author ntkhanh
 */
public class CheckAnswer {
    
        public static String reverse(String str) {
        String tmp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            tmp += str.substring(i, i + 1);
        }
            System.out.println(tmp);
        return tmp;
    }
    
    public static String chuanHoa(String strInput) {
        String strOutput = "";
        StringTokenizer strToken = new StringTokenizer(strInput, " ,\t,\r");
        strOutput += "" + chuyenInHoa(strToken.nextToken());
        while (strToken.hasMoreTokens()) {
            strOutput += " " + chuyenInHoa(strToken.nextToken());
        }
        return (strOutput);
    }
    public static String chuyenInHoa(String str) {
        String s, strOutput;
        s = str.substring(0, 1);
        strOutput = str.replaceFirst(s, s.toUpperCase());
        return (strOutput);
    }
    
     /**
     * Tìm ước số chung lớn nhất (USCLN)
     * 
     * @param a: số nguyên dương
     * @param b: số nguyên dương
     * @return USCLN của a và b
     */
    public static int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }
     
    /**
     * Tìm bội số chung nhỏ nhất (BSCNN)
     * 
     * @param a: số nguyên dương
     * @param b: số nguyên dương
     * @return BSCNN của a và b
     */
    public static  int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }
    
   

    public static boolean checkMaxNumericAnswer(int[] numericExam, int respond) {
        if (numericExam == null) {
            return false;
        } else {
            int maxValue = numericExam[0];
            for (int i = 1; i < numericExam.length; i++) {
                if (maxValue < numericExam[i]) {
                    maxValue = numericExam[i];
                }
            }
            if (maxValue == respond) {
                return true;
            } else {
               return false;
            }
        }
        
    }

}
