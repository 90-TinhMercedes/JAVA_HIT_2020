package Lesson_01;

import java.util.Scanner;

public abstract class Product {
    protected String code;
    protected String name;
    protected String brand;
    protected String date;

    public Product() {

    }

    public void inputProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code product: ");
        this.code = scanner.nextLine();
        System.out.printf("Enter name product: ");
        this.name = scanner.nextLine();
        System.out.printf("Enter brand product: ");
        this.brand = scanner.nextLine();
        System.out.printf("Enter date: ");
        this.date = scanner.nextLine();
    }

    public void showProduct() {
        System.out.printf("%20s %20s %20s %20s", this.code, this.name, this.brand, this.date);
    }

    public abstract void inputAirConditioner();

    public abstract void showAirConditioner();

    public Product(String code, String name, String brand, String date) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
