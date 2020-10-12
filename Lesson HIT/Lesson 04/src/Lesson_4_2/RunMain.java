package Lesson_4_2;

import Lesson_4_1.SinhVien;

public class RunMain {
    public static void main(String[] args) {
        Information[] arrST = new Information[2];
        for (int i = 0; i < arrST.length; i++) {
            arrST[i] = new Information();
            System.out.println("Enter student " + (i + 1) + " :");
            arrST[i].SetInfor();
        }
        for (int i = 0; i < arrST.length; i++) {
            arrST[i].ShowInfor(i);
        }
    }
}

