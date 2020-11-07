package Lesson_03;

import java.util.Scanner;

public class Product {
    private String code;
    private String product;
    private int amount;
    private int price;

    public Product() {

    }

    public  void inputProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code product: ");
        this.code = scanner.nextLine();
        System.out.printf("Enter product: ");
        this.product = scanner.nextLine();
        System.out.printf("Enter amount: ");
        this.amount = scanner.nextInt();
        System.out.printf("Enter price product: ");
        this.price = scanner.nextInt();
    }
    public void showProduct(){
        System.out.printf("%20s %20s %20d %20d %20d\n", this.code, this.product, this.amount, this.price, this.amount * this.price);
    }
    public Product(String code, String product, int amount, int price) {
        this.code = code;
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
