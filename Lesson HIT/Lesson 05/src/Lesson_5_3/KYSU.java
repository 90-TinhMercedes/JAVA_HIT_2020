package Lesson_5_3;

import java.util.Scanner;

public class KYSU extends PERSON {
    private String nganh;
    private int namTN;

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Nhập họ tên: ");
//        hoTen = scanner.nextLine();
//        System.out.printf("Nhập ngày sinh: ");
//        ngaySinh = scanner.nextLine();
//        System.out.printf("Nhập quê quán: ");
//        queQuan = scanner.nextLine();
        super.Nhap();
        System.out.printf("Nhập ngành: ");
        nganh = scanner.nextLine();
        System.out.printf("Nhập năm tốt nghiệp: ");
        namTN = scanner.nextInt();
    }

    public void Xuat() {
        super.Xuat();
        System.out.println("Ngành: " + nganh);
        System.out.println("Năm tốt nghiệp: " + namTN);
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getNamTN() {
        return namTN;
    }

    public void setNamTN(int namTN) {
        this.namTN = namTN;
    }
}
