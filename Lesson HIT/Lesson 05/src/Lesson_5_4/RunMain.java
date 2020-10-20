package Lesson_5_4;

import java.util.ArrayList;
import java.util.Collections;

public class RunMain {
    public static void main(String[] args) {
        ArrayList<SinhVien> list = new ArrayList<>();
        SinhVien sv1  = new SinhVien("2019", "Chi Tinh");
        SinhVien sv2 = new SinhVien("2020", "Love Veigar");

//        SinhVien temp = sv1;
//        sv1 = sv2;
//        sv2 = temp;
//        System.out.println(sv1);
//        System.out.println(sv2);

        list.add(sv1);
        list.add(sv2);
//        Collections.swap(list, 0, 1);
        SinhVien temp = list.get(0); // temp = sv1
        list.set(0, list.get(1)); // sv2 sv2
        list.set(1, temp); // sv2 sv2 = temp >> sv2 sv1 done

        for(SinhVien sv : list){
            System.out.println(sv);
        }
//        System.out.println(sv1);
//        System.out.println(sv2);

    }
}
