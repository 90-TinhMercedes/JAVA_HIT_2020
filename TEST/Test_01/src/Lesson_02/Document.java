package Lesson_02;

import java.util.Scanner;

public abstract class Document {
    protected String ID;
    protected String name;
    protected String publisher;
    protected double price;

    public Document() {

    }

    public void inputDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter ID: ");
        this.ID = scanner.nextLine();
        System.out.printf("Enter book: ");
        this.name = scanner.nextLine();
        System.out.printf("Enter publisher: ");
        this.publisher = scanner.nextLine();
        System.out.printf("Enter price: ");
        this.price = scanner.nextInt();
    }

    public void outputDocument() {
        System.out.printf("%20s %20s %20s %20.2f", this.ID, this.name, this.publisher, this.price);
    }

    public abstract void inputBook();

    public abstract void outputBook();

    public Document(String ID, String name, String publisher, double price) {
        this.ID = ID;
        this.name = name;
        this.publisher = publisher;
        this.price = price;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
