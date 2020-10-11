package Bai_03;

public class RunMain {
    public static void main(String[] args) {
        HangHoa FirstItem = new HangHoa("CMTT_1945", "Bột Giặt Omo", 90000, 3);
        HangHoa SecondItem = new HangHoa();
        SecondItem.setMaHang("GPMN_1975");
        SecondItem.setTenHang("Dầu Ăn Simply");
        SecondItem.setDonGia(45000);
        SecondItem.setSoLuong(5);
        System.out.println("----------------------------------------------");
//        System.out.println("-----First Item Information-----");
        FirstItem.Xuat();
        System.out.println("----------------------------------------------");
//        System.out.println("-----Second Item Information-----");
        SecondItem.Xuat();
        System.out.println("----------------------------------------------");

    }

}
