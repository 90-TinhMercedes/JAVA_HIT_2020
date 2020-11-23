package Demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RunMainVer02 {
    public static void main(String[] args) {
        String[] arr = {"Trung", "Doan", "Hiệp", "Tình", "Doan", "Trung", "Hiệp", "Máy Dập Điện Biên", "Máy Dập Điện Biên"};
//        Set<String> set = new TreeSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }

//        for (String s : arr) {
//            set.add(s);
//        }

        Set<String> set = new HashSet<>(Arrays.asList(arr));

        for (String s : set) {
            System.out.println(s);
        }
    }
}
