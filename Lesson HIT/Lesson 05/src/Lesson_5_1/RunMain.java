package Lesson_5_1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
////        SinhVien[] student = new SinhVien[n];
//        ArrayList<SinhVien> list = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            SinhVien student = new SinhVien();
//            student.Nhap();
//            list.add(student);
//        }
//        for(SinhVien sv : list){
//            System.out.println(sv);
//        }
//
//
//
//    }
    public static void main(String[] args) {
        Student sv1 = new Student();
        sv1.Nhap();
        sv1.Xuat();
    }

}
