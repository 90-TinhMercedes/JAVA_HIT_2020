package Lesson_03;

import java.util.Scanner;

public class PHIEU {
    private String codeCoupon;
    private HANG[] product;

    public void InputCoupon() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code coupon: ");
        this.codeCoupon = scanner.nextLine();
        int n;
        System.out.printf("Enter amount product: ");
        n = scanner.nextInt();
        product = new HANG[n];
        for (int i = 0; i < product.length; i++) {
            System.out.println("Enter product " + (i + 1) + ": ");
            product[i] = new HANG();
            product[i].InputProduct();
        }
    }

    public void ShowCoupon(){
        System.out.println("-----------------------------------------------");
        System.out.println("CODE COUPON: " + this.codeCoupon);
        System.out.println("-----------------------------------------------");
        for(int i=0; i< product.length; i++){
            System.out.println("INFORMATION PRODUCT " + (i+1) + ": ");
            product[i].ShowProduct();
            System.out.println("-----------------------------------------------");
        }
    }

    public String getCodeCoupon() {
        return codeCoupon;
    }

    public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
    }

    public HANG[] getProduct() {
        return product;
    }

    public void setProduct(HANG[] product) {
        this.product = product;
    }

}
