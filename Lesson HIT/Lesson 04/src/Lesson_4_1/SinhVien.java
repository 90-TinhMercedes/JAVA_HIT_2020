package Lesson_4_1;

import java.util.Scanner;

public class SinhVien {
    private String maSInhVien;
    private String hoTen;
    private Date ngaySinh;
    public SinhVien() {

    }

    public SinhVien(String maSInhVien, String hoTen, Date ngaySinh) {
        this.maSInhVien = maSInhVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public void HienThi() {
        System.out.print("Ho ten: " + hoTen);
        System.out.print("Code: " + maSInhVien);
        System.out.println(ngaySinh.toString());
    }

    public void HienThi(int stt){
        System.out.println("STT: " + stt + " ");
        System.out.print("Ho ten: " + hoTen + " ");
        System.out.print("Code: " + maSInhVien);
        System.out.println(ngaySinh.toString());
    }

    public String getMaSInhVien() {
        return maSInhVien;
    }

    public void setMaSInhVien(String maSInhVien) {
        this.maSInhVien = maSInhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    //    @Override
//    public String toString() {
//        return "SinhVien{" +
//                "maSInhVien='" + maSInhVien + '\'' +
//                ", hoTen='" + hoTen + '\'' +
//                '}';
//    }
//
    public void InputInfor(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code: ");
        this.maSInhVien = scanner.nextLine();
        System.out.printf("Enter full name: ");
        this.hoTen = scanner.nextLine();
        System.out.println();
        System.out.println("Enter infor your date: ");
        ngaySinh = new Date();
        ngaySinh.InputDate();
    }
}
