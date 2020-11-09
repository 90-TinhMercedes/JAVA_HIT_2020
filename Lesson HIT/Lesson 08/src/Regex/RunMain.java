package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunMain {
    public static void main(String[] args) {
//        String regex = "\\d+";
        String regex = "^\\d+$";
        String regexUser = "^[a-zA-Z0-9]{6,}+$";
        String regexPassword = "^[0-9]{8,}+$";

        Matcher matcher;
        Pattern patternUsername = Pattern.compile(regexUser);
        Pattern patternPassword = Pattern.compile(regexPassword);
//        Pattern pattern = Pattern.compile(regex);
//        String str = "54554fgtgteh5485";
//        String str = "545545485";
        String strUsername = "chiandtinh";
//        String strPassword = "fhrgifurguf";
        String strPassword = "157667626762167";

        matcher = patternUsername.matcher(strUsername);
        System.out.println("Check Username: " + matcher.find());
        matcher = patternPassword.matcher(strPassword);
        System.out.println("Check Password: " + matcher.find());
        System.out.println("Check Password: " + patternPassword.matcher(strPassword).find());


    }
}

