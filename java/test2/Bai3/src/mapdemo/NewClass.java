/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapdemo;

/**
 *
 * @author Hoang Quyet
 */
public class NewClass {
    public static void main(String[] args) {
        String regex="[0-9]\\w{3,5}";
        String s="133abcgff3";
        System.out.println(s.matches(regex));
    }
}
