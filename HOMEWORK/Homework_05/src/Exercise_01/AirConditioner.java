package Lesson_01;

import java.util.Scanner;

public class AirConditioner extends Product {
    private String wattage;
    private double price;

    public AirConditioner() {

    }

    @Override
    public void inputAirConditioner() {
        Scanner scanner = new Scanner(System.in);
        super.inputProduct();
        System.out.printf("Enter wattage: ");
        this.wattage = scanner.nextLine();
        System.out.printf("Enter price product: ");
        this.price = scanner.nextDouble();
        scanner.nextLine();
    }

    @Override
    public void showAirConditioner() {
        super.showProduct();
        System.out.printf("%20s %20.2f\n", this.wattage, this.price);
    }

    public AirConditioner(String wattage, double price) {
        this.wattage = wattage;
        this.price = price;
    }

    public AirConditioner(String code, String name, String brand, String date, String wattage, double price) {
        super(code, name, brand, date);
        this.wattage = wattage;
        this.price = price;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
