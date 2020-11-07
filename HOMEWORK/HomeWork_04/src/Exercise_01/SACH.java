package Lesson_01;

import java.util.Scanner;

public class SACH {
    private String codeBook;
    private String nameBook;
    private String publishing;
    private int page;
    private int price;

    public void NHAP(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code book: ");
        this.codeBook = scanner.nextLine();
        System.out.printf("Enter name book: ");
        this.nameBook = scanner.nextLine();
        System.out.printf("Enter publishing company: ");
        this.publishing = scanner.nextLine();
        System.out.printf("Enter number of page: ");
        this.page = scanner.nextInt();
        System.out.printf("Enter price of book: ");
        this.price = scanner.nextInt();
    }

    public void XUAT(){
        System.out.println("Code: " + this.codeBook);
        System.out.println("Book: " + nameBook);
        System.out.println("Publishing company: " + this.publishing);
        System.out.println("Page: " + this.page);
        System.out.println("Price: " + this.price + " VND");
    }

//    public SACH(String codeBook, String nameBook, String publishing, int page, int price) {
//        this.codeBook = codeBook;
//        this.nameBook = nameBook;
//        this.publishing = publishing;
//        this.page = page;
//        this.price = price;
//    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

