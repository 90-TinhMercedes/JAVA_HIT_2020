package Lesson_05;

import java.util.Scanner;

public abstract class Person {
    protected String fullName;
    protected String date;
    protected String homeTown;

    public Person() {

    }

    public void inputPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full name: ");
        this.fullName = scanner.nextLine();
        System.out.print("Enter date: ");
        this.date = scanner.nextLine();
        System.out.print("Enter your home town: ");
        this.homeTown = scanner.nextLine();
    }

    public void showPerson() {
        System.out.printf("%20s %20s %20s", this.fullName, this.date, this.homeTown);
    }

    public abstract void inputStudent();

    public abstract void showStudent();

    public Person(String fullName, String date, String homeTown) {
        this.fullName = fullName;
        this.date = date;
        this.homeTown = homeTown;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

}
