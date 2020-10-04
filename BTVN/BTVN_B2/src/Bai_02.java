/*Bài 02: Nhập một mảng n số nguyên.
- Tìm min và max trong mảng
- Sắp xếp mảng theo thứ tự tăng dần*/

import java.util.Scanner;

public class Bai_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a[], n;
        System.out.printf("Enter n: ");
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[" + i + "] = ");
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        System.out.println("Min = " + a[0] + ", " + "Max = " + a[n - 1]);
        System.out.printf("Your array after sort: ");
        for(int i=0; i<n; i++)
            System.out.printf(a[i] + "  ");
    }
}
