package Lesson_04;

import java.util.Scanner;

public class Student {
    private String ID;
    private String name;
    private int age;
    private String address;
    private float GPA;

    public Student() {

    }

    public void inputInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter ID: ");
        this.ID = scanner.nextLine();
        System.out.printf("Enter full name: ");
        this.name = scanner.nextLine();
        System.out.printf("Enter age: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Enter address: ");
        this.address = scanner.nextLine();
        System.out.printf("Enter GPA: ");
        this.GPA = scanner.nextInt();
        scanner.nextLine();
    }

    public void showInformation() {
        System.out.printf("%20s %20s %20d %20s %20.2f\n", this.ID, this.name, this.age, this.address, this.GPA);
    }

    public Student(String ID, String name, int age, String address, float GPA) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.address = address;
        this.GPA = GPA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
}
