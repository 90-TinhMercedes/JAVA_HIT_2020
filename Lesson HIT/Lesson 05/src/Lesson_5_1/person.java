package Lesson_5_1;

import java.util.Scanner;

public class person {
//    protected String theCC;
//    protected String hoTen;
//    protected String gioiTinh;

    private String theCC;
    private String hoTen;
    private String gioiTinh;
    public person(){

    }
    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap the can cuoc: ");
        theCC = scanner.nextLine();
        System.out.printf("Nhap ho ten: ");
        hoTen = scanner.nextLine();
        System.out.printf("Nhap gioi tinh: ");
        gioiTinh = scanner.nextLine();
    }

    public void Xuat(){
        System.out.println("the can cuoc: " + theCC);
        System.out.println(" ho ten: " + hoTen);
        System.out.println(" gioi tinh: " + gioiTinh);
    }
    public String getTheCC() {
        return theCC;
    }

    public void setTheCC(String theCC) {
        this.theCC = theCC;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public person(String theCC, String hoTen, String gioiTinh) {
        this.theCC = theCC;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
    }
}
