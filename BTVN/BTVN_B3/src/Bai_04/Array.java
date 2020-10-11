package Bai_04;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Array {
    private int[] array;
    private int n;

    public Array() {

    }

    public Array(int[] array, int n) {
        this.array = array;
        this.n = n;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void EnterArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter amount of array: ");
        int amount = scanner.nextInt();
        this.setN(amount);
        this.array = new int[this.getN()];
        for (int i = 0; i < this.getN(); i++) {
            System.out.printf("Arr [" + i + "] = ");
            this.array[i] = scanner.nextInt();
        }
    }

    public void Show() {
        for (int i = 0; i < this.getN(); i++) {
            System.out.printf(array[i] + "  ");
        }
        System.out.println();
    }

    public int Sum() {
        int sumArr = 0;
        for (int i = 0; i < this.getN(); i++)
            sumArr += array[i];
        return sumArr;
    }
}
