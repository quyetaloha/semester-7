/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapdemo;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        HashMap mymap = new HashMap();
        mymap.put("mot", "One one");
        mymap.put("hai", "Two two");
        mymap.put("ba", "Three three");
        mymap.put("bon", "Four four");
        System.out.println(mymap);
        //using Iterator
        Iterator iter = mymap.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            System.out.println(key + ": " + mymap.get(key));
        }

    }
}
