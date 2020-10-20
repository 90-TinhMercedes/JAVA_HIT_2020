package Lesson_5_1;

import java.util.Scanner;

public class SinhVien {
    String hoTen;
    String diaChi;

    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.printf("Enter họ tên: ");
        scanner.nextLine();
        System.out.printf("Enter địa chỉ: ");

    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
