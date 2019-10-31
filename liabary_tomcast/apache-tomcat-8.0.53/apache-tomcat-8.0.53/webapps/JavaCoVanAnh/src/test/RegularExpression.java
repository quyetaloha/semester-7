/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Hoang Quyet
 */
public class RegularExpression {
    public static void main(String[] args) {
        String ex="^[a-w]\\w{3,17}@[a-w]{3,10}\\.[a-w]{3,10}";
        String s="quyethocngu@gmail.com";
        System.out.println(s.matches(ex));
    }
}
