package Lesson_01;

import java.io.CharConversionException;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your string: ");
//        String str = scanner.nextLine();

        String str = "bn01da6d47";
        int sum = 0;
        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if (ch >= '0' && ch <= '9') {
//                count++;
//                sum += (int) ch - 48;
//            }
//        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count++;
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        int mul = 1;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int x = Integer.parseInt(String.valueOf(str.charAt(i)));
                if(x != 0)
                    if (sum % x == 0) {
                        mul *= x;
                    }
            }
        }

        System.out.println("Your string has " + count + " numeric characters.");
        System.out.println("Multiplication: " + mul);


    }
}
