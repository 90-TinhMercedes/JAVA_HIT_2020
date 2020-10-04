//Bài 01: Nhập vào 3 số ngẫu niên, tìm số lớn nhất trong 3 số. (Không sử dụng mảng)

import java.util.Scanner;

public class Bai_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        System.out.printf("Enter number a, b, c: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        System.out.println(Math.max(Math.max(a, b), c));
    }
}
