package Lesson_02;

import java.util.Scanner;

public class Book extends Document{
    private int nameOfPage;
    private String author;

    public Book(){

    }

    @Override
    public void inputBook(){
        Scanner scanner = new Scanner(System.in);
        super.inputDocument();
        System.out.printf("Enter number of page: ");
        this.nameOfPage = scanner.nextInt();
        System.out.printf("Enter author: ");
        scanner.nextLine();
        this.author = scanner.nextLine();
    }

    @Override
    public void outputBook(){
        super.outputDocument();
        System.out.printf("%20d %20s\n", this.nameOfPage, this.author);
    }

    public Book(int nameOfPage, String author) {
        this.nameOfPage = nameOfPage;
        this.author = author;
    }

    public Book(String ID, String name, String publisher, double price, int nameOfPage, String author) {
        super(ID, name, publisher, price);
        this.nameOfPage = nameOfPage;
        this.author = author;
    }

    public int getNameOfPage() {
        return nameOfPage;
    }

    public void setNameOfPage(int nameOfPage) {
        this.nameOfPage = nameOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
