package Lesson_03;

import java.util.ArrayList;
import java.util.Scanner;

public class Coupon {
    private String codeCoupon;
    private String coupon;
    DateTime a;
    private ArrayList<Product> x = new ArrayList<>();
    private int n;

    public Coupon() {

    }

    public void inputCoupon() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code coupon: ");
        this.codeCoupon = scanner.nextLine();
        System.out.printf("Enter name of coupon: ");
        this.coupon = scanner.nextLine();
        a = new DateTime();
        this.a.inputDateTime();
        System.out.printf("Enter amount of product: ");
        this.n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter product " + (i + 1) + ": ");
            Product N = new Product();
            N.inputProduct();
            x.add(N);
        }
    }

    public void title() {
        System.out.printf("%10s %20s %20s %20s %20s %20s", "STT", "Code", "Product", "Amount", "Price", "Total\n");
    }

    public void showCoupon() {
        System.out.println("Code coupon: " + getCodeCoupon());
        System.out.println("Coupon: " + getCoupon());
        System.out.printf("Date time: ");
        a.showDateTime();
        title();
        for (int i = 0; i < x.size(); i++) {
            System.out.printf("%10d", (i + 1));
            x.get(i).showProduct();
        }
    }

    public Coupon(String codeCoupon, String coupon, DateTime a, ArrayList<Product> x, int n) {
        this.codeCoupon = codeCoupon;
        this.coupon = coupon;
        this.a = a;
        this.x = x;
        this.n = n;
    }

    public String getCodeCoupon() {
        return codeCoupon;
    }

    public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public DateTime getA() {
        return a;
    }

    public void setA(DateTime a) {
        this.a = a;
    }

    public ArrayList<Product> getX() {
        return x;
    }

    public void setX(ArrayList<Product> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
