package Functional_Interface;

public class RunMain {
    public static void main(String[] args) {
//        Person person = new Person() {
//            //anonymous function
//            @Override
//            public void Sleep() {
//
//            }
//        };
//        person.Sleep();

        Person person = () -> System.out.println("Sleepppppp!");
        person.Sleep();
    }
}
