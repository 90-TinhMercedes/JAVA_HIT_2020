package Lesson_02;

import java.util.Scanner;

public class ComplexNumber {
    private int realCN;
    private int virtualCN;

    public ComplexNumber() {

    }

    public void inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter real part: ");
        this.realCN = scanner.nextInt();
        System.out.printf("Enter virtual part: ");
        this.virtualCN = scanner.nextInt();
    }

    public void showNumber() {
        System.out.println(this.realCN + " + " + this.virtualCN + "i");
    }

    public ComplexNumber plush(ComplexNumber x){
        ComplexNumber y = new ComplexNumber();
        y.realCN = this.realCN + x.realCN;
        y.virtualCN = this.virtualCN + x.virtualCN;
        return y;
    }

    public ComplexNumber subtraction(ComplexNumber x){
        ComplexNumber y = new ComplexNumber();
        y.realCN = this.realCN - x.realCN;
        y.virtualCN = this.virtualCN - x.virtualCN;
        return y;
    }

    public ComplexNumber(int realCN, int virtualCN) {
        this.realCN = realCN;
        this.virtualCN = virtualCN;
    }

    public int getRealCN() {
        return realCN;
    }

    public void setRealCN(int realCN) {
        this.realCN = realCN;
    }

    public int getVirtualCN() {
        return virtualCN;
    }

    public void setVirtualCN(int virtualCN) {
        this.virtualCN = virtualCN;
    }
}
