package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunMain {
    public static void main(String[] args) {
        Person person1 = new Person(3, "GFE");
        Person person2 = new Person(2, "Love");
        Person person3 = new Person(2, "Veigar");
        Person person4 = person1;
//        System.out.pirintln(person1 == person4);
//        System.out.println(person1.compareTo(person2));
//        System.out.println(person2.compareTo(person3));

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        for(Person p : list){
            System.out.println(p);
        }
        Collections.sort(list);
        System.out.println("---------------------");
        for(Person p : list){
            System.out.println(p);
        }
    }
}
