
package mapdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class GroupByDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(); 
        people.add(new Person("John", "London", 21)); 
        people.add(new Person("Swann", "London", 21)); 
        people.add(new Person("Kevin", "London", 23)); 
        people.add(new Person("Monobo", "Tokyo", 23)); 
        people.add(new Person("Sam", "Paris", 23)); 
        people.add(new Person("Nadal", "Paris", 31)); 
// Now let's group all person by city in pre Java 8 world 
Map<String,List<Person>> personByCity = new HashMap<>(); 
for(Person p : people){ 
    if(!personByCity.containsKey(p.getCity())){ 
        personByCity.put(p.getCity(), new ArrayList<>()); 
    } 
    personByCity.get(p.getCity()).add(p); 
} 
System.out.println("Person grouped by cities : " + 
        personByCity); 
// Let's see how we can group objects in Java 8 
personByCity = people.stream() .collect(Collectors.groupingBy(Person::getCity)); 
System.out.println("Person grouped by cities in Java 8: " + 
        personByCity); 
// Now let's group person by age 
Map<Integer,List<Person>> personByAge = people.stream() 
        .collect(Collectors.groupingBy(Person::getAge)); 
System.out.println("Person grouped by age in Java 8: " + 
        personByAge); 
    }
    }
         

class Person{ 
    private String name; 
    private String city; 
    private int age; 
    public Person(String name, String city, int age) { 
        this.name = name; 
        this.city = city; 
        this.age = age; 
    } 
    public String getName() { 
        return name; 
    } 
    public void setName(String name) { 
        this.name = name; 
    } 
    public String getCity() { 
        return city; 
    } 
    public void setCity(String city) { 
        this.city = city; 
    } 
    public int getAge() { 
        return age; 
    } 
    public void setAge(int age) { 
        this.age = age; 
    } 
    
    @Override
    public String toString() { 
        return String.format("%s %d)", name, age); 
    } 
    @Override 
    public int hashCode() { 
        int hash = 7; 
        hash = 79 * hash + Objects.hashCode(this.name); 
        hash = 79 * hash + Objects.hashCode(this.city); 
        hash = 79 * hash + this.age; return hash; 
    } 
    @Override 
    public boolean equals(Object obj) { 
        if (obj == null) { 
            return false; 
        } 
        if (getClass() != obj.getClass()) { 
            return false; 
        } 
        final Person other = (Person) obj; 
        if (!Objects.equals(this.name, other.name)) { 
            return false; 
        } 
        if (!Objects.equals(this.city, other.city)) { 
            return false; 
        } 
        if (this.age != other.age) { 
            return false; 
        } 
        return true; 
    } 
}
