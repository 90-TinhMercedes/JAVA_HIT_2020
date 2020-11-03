package Demo_Interface;

public class Dog implements Animal { // Class triển khai interface

    @Override
    public void Eat() {
        System.out.println("Eat!!");
    }

    @Override
    public void Sleep() {
        System.out.println("Sleep!!");
    }
}
