package Lesson_01;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void title() {
        System.out.printf("%20s %20s %20s %20s %20s %20s\n", "Code", "Product", "Brand", "Date", "Wattage", "Price");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter amount of Air Conditioner: ");
        int n = scanner.nextInt();
        ArrayList<AirConditioner> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter product " + (i + 1) + ": ");
            AirConditioner airConditioner = new AirConditioner();
            airConditioner.inputAirConditioner();
            list.add(airConditioner);
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        title();
        for (AirConditioner i : list) {
            i.showAirConditioner();
        }

        double minPrice = list.get(0).getPrice();
        for (AirConditioner i : list)
            if (i.getPrice() < minPrice)
                minPrice = i.getPrice();

        boolean checkProduct = false;
        for (AirConditioner i : list) {
            if (i.getBrand().compareToIgnoreCase("Electrolux") == 0 && i.getPrice() == minPrice) {
                checkProduct = true;
                break;
            }
        }

        if (checkProduct) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            for (AirConditioner i : list) {
                if (i.getBrand().compareToIgnoreCase("Electrolux") == 0 && i.getPrice() == minPrice)
                    i.showAirConditioner();
            }
        } else {
            System.out.println("No Electrolux product!");
        }
    }
}
