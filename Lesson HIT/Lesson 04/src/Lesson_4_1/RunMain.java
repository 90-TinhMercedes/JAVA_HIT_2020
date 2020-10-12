package Lesson_4_1;

public class RunMain {
    public static void main(String[] args) {

//        SinhVien x = new SinhVien("2019","Doan Vũ");
        SinhVien[] arrSV = new SinhVien[2];
        for(int i=0; i<arrSV.length; i++){
            arrSV[i] = new SinhVien();
//            arrSV[i].setMaSInhVien("" + i);
//            arrSV[i].setHoTen("Điệp" + i);
            System.out.println("Enter student " + (i+1) + " :");
            arrSV[i].InputInfor();
        }
        for(int i=0; i< arrSV.length; i++){
//            arrSV[i].HienThi();
            arrSV[i].HienThi(i);
        }
    }
}
