package Polymorphism;

import java.util.ArrayList;
import java.util.List;

public class RunMain {
    public static void main(String[] args) {
//        Student student = new Student();
//        Worker worker = new Worker();

        Person person = new Student();
        person.Address();

        person = new Worker();
        person.Address();

        List<Student> list = new ArrayList<>();

    }
}
