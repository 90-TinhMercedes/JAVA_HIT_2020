import Account.Account;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String now = simpleDateFormat.format(date);
        Account account = new Account(1, "Chi Tinh", "GFELoveVeigar", "ngoctrinH89!", "tinhveigar@gmail.com", "098989898989", now);
        System.out.println(account);
    }
}
