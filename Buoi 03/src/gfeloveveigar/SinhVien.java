package gfeloveveigar;

public class SinhVien {
//    private int maSinhVien;
    private static int maSinhVien;
    private String hoTen;
    private String diaChi;

    public SinhVien() {
        maSinhVien++;
    }

    public SinhVien( String hoTen, String diaChi) {
//        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }


    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
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

    public void ShowInfor(){
        System.out.println(maSinhVien);
        System.out.println(hoTen);
        System.out.println(diaChi);
    }
}
