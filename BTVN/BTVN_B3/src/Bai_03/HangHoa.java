package Bai_03;

public class HangHoa {
    private String maHang;
    private String tenHang;
    private int donGia;
    private int soLuong;

    public HangHoa(){

    }
    public HangHoa(String maHang, String tenHang, int donGia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void Xuat() {
        System.out.println("Code: " + this.getMaHang());
        System.out.println("Item name: " + getTenHang());
        System.out.println("Amount: " + getSoLuong());
        System.out.println("Unit price: " + getDonGia() + " VND");
        System.out.println("Total: " + this.getSoLuong() * this.getDonGia() + " VND");
    }
}
