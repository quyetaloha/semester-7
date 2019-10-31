
package mapdemo;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;




public class Group3 {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, 9.99),
                new Item("banana", 20, 19.99),
                new Item("orang", 10, 29.99),
                new Item("watermelon", 10, 29.99),
                new Item("papaya", 20, 9.99),
                new Item("apple", 10, 19.99),
                new Item("banana", 10, 29.99),
                new Item("apple", 20, 9.99)
        );
        Map<String, Long> counting = items.stream().collect(
          Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
          Collectors.groupingBy(Item::getName, 
                  Collectors.summingInt(Item::getQty)));
        System.out.println(sum);
        
        
        Map<String,Double> avg = items.stream().collect(
                Collectors.groupingBy(Item::getName,
          Collectors.averagingInt(Item::getQty)));
        System.out.println(avg);
        
        Optional<Item> max = 
            items.stream()
            .collect(Collectors.maxBy(Comparator.
                    comparing(Item::getQty)));
        System.out.println("Item with max qty:"+            
             (max.isPresent()? max.get():"Not Applicable"));
        
        Optional<Item> min = 
            items.stream()
            .collect(Collectors.minBy(Comparator.
                    comparing(Item::getQty)));
        System.out.println("Item with min qty:"+            
             (min.isPresent()? min.get():"Not Applicable"));
        
                
        Map<String, Item> o =  
        items.stream().collect(
        Collectors.groupingBy(Item::getName,
         Collectors.collectingAndThen(
         Collectors.reducing((Item d1, Item d2)
         -> d1.getPrice()> d2.getPrice()? d1 : d2),
          Optional::get)));
    
    System.out.println(o);
    }    
}
class Item {
    private String name;
    private int qty;
    private Double price;

    public Item() {
    }

    public Item(String name, int qty, Double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String toString(){
        return name+"\t"+qty+"\t"+price;
    }
}