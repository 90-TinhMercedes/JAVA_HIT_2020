package Lesson_03;

import java.util.Scanner;

public class HANG {
    private String codeProduct;
    private String nameProduct;
    private int unitPrice;

    public void InputProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code product: ");
        this.codeProduct = scanner.nextLine();
        System.out.printf("Enter name product: ");
        this.nameProduct = scanner.nextLine();
        System.out.printf("Enter unit price: ");
        this.unitPrice = scanner.nextInt();
    }
    public void ShowProduct(){
        System.out.println("Code product: " + this.codeProduct);
        System.out.println("Name product: " + this.nameProduct);
        System.out.println("Unit price product: " + this.unitPrice + " VND");
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
