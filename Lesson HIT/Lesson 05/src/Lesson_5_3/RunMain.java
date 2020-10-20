package Lesson_5_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số lượng kỹ sư: ");
        int n = scanner.nextInt();
        ArrayList<KYSU> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            KYSU engineer = new KYSU();
            engineer.Nhap();
            list.add(engineer);
        }
        for (KYSU ks : list) {
            ks.Xuat();
        }
        int max = list.get(0).getNamTN();
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i).getNamTN())
                max = list.get(i).getNamTN();
        }
        System.out.println("Kỹ sư tốt nghiệp gần đây nhất: ");
        for (KYSU ks : list) {
            if (ks.getNamTN() == max)
                ks.Xuat();
        }
    }
}
