package Lesson_5_1;

import java.util.Scanner;

public class Student extends person{
    private String maSV;
    private String nganh;

    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhap the can cuoc: ");
//        theCC = scanner.nextLine();
//        System.out.printf("Nhap ho ten: ");
//        hoTen = scanner.nextLine();
//        System.out.printf("Nhap gioi tinh: ");
//        gioiTinh = scanner.nextLine();
        super.Nhap();
        System.out.printf("Nhap ma sinh vien: ");
        maSV = scanner.nextLine();
        System.out.printf("Nhap nganh hoc: ");
        nganh = scanner.nextLine();
    }
    public void Xuat(){
//        System.out.print("the can cuoc: " + theCC);
//        System.out.printf(" ho ten: " + hoTen);
//        System.out.printf(" gioi tinh: " + gioiTinh);

        super.Xuat();
        System.out.println(" ma sinh vien: " + maSV);
        System.out.println(" nganh hoc: " + nganh);
    }
}
