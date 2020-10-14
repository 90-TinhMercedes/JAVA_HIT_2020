package Lesson_01;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.printf("Enter amount book: ");
        n = scanner.nextInt();
        SACH[] book = new SACH[n];
        for(int i=0; i< book.length; i++){
            book[i] = new SACH();
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter information book " + (i+1) + ": ");
            book[i].NHAP();
        }
        for(int i=0; i< book.length; i++){
            System.out.println("----------------------------------------------------------");
            System.out.println("INFORMATION BOOK " + (i+1) + ": ");
            book[i].XUAT();
        }


    }
}
