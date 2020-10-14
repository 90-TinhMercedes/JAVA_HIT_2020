//Bài 05: Nhập vào một chuỗi bất kỳ. Tính trung bình cộng các chữ số trong chuỗi

import java.util.Scanner;

public class Bai_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your string: ");
        String str = scanner.nextLine();
        float sum = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sum += (int) ch - 48;
                count++;
            }
        }
        System.out.println("Average = " + sum / count);
    }
}
