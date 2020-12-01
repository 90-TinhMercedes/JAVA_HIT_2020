package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class RunMain {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tinh", 20));
        list.add(new Person("Doan", 18));
        list.add(new Person("Huan", 19));

        Consumer<Person> consumer = (Person p) -> System.out.println(p);
//        list.stream().forEach(consumer);

//        Consumer<Person> consumer = (Person p) -> System.out.println(p);
//        list.stream().forEach(p -> System.out.println(p));
//        list.stream().forEach(System.out::println); // methor reference
//        list.forEach(System.out::println);

//        Person p = list.stream().max(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        }).get();
//        System.out.println(p);


//        list.stream().filter();
        Predicate<Person> predicate = (Person p) -> {
          if (p.getAge() > 19){
              return true;
          }
          return false;
        };
        list.stream().filter(predicate).forEach(consumer);

    }
}
