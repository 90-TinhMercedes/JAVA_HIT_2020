package Regex;

import java.util.regex.Pattern;

public class CheckPassword {
    public static void main(String[] args) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        String str = "gDf8888dsf";
        System.out.println("Check: " + pattern.matcher(str).find());

    }
}
