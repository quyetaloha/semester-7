/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacedemo;

/**
 *
 * @author ADMIN
 */
//Main.class
public class Main {
    public static void main(String[] args) {
        Demo1 d=new Sub("Ha anh");//upcasting
        Person p=new Person("HHH nnn");
        Person p1=new Sub("hdfjh dfdf");
        Sub s=new Sub("lan");
        System.out.println("Case 1");
        s.m1();
        System.out.println(s.m2());
        System.out.println("Case 2");
        d.m1();
        System.out.println(d.m2());
        s.m3();
        s.m4();
        ((Sub)d).m3();
        AbstractDemo a=new Sub2("hhdf dfdf");
        Sub2 s1=new Sub2("Ha anh");
        s1.m6();
        //Main$1
        Demo d2=new Demo() {
            @Override
            public void m3() {
                System.out.println("Anonymous 3");
            }

            @Override
            public void m4() {
                System.out.println("Anonymous 4");
            }
        };
        d2.m3();
        d2.m4();
        //Main$2
        AbstractDemo a1=new AbstractDemo("Tu Anh") {
            @Override
            public void m6() {
                System.out.println("Anonymous 6");
            }
            
            @Override
            public void m7() {
                System.out.println("Anonymous 7");
            }
        };
        a1.setX(45);
        a1.m6();
    }
    
}
