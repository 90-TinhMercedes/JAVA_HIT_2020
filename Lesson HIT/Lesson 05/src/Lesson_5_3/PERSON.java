package Lesson_5_3;

import java.util.Scanner;

public class PERSON {
    protected String hoTen;
    protected String ngaySinh;
    protected String queQuan;

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập họ tên: ");
        hoTen = scanner.nextLine();
        System.out.printf("Nhập ngày sinh: ");
        ngaySinh = scanner.nextLine();
        System.out.printf("Nhập quê quán: ");
        queQuan = scanner.nextLine();
    }

    public void Xuat() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Quê quán: " + queQuan);
    }

    public PERSON() {

    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public PERSON(String hoTen, String ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }
}
