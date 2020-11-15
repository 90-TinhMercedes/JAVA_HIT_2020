package Account;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RunMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("OPTION");
            System.out.println("1. Create new account.");
            System.out.println("2. Login to an existing account.");
            System.out.println("3. Sort accounts by username.");
            System.out.println("4. Exit.");
            System.out.println("-------------------------------------------------------");
            int selection;
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    CreateNewAccount();
                    break;
                case 2:
                    LoginToAnExistingAccount();
                    break;
                case 3:
                    SortAccountByUsername();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    private static void CreateNewAccount() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String regexUser = "^[a-zA-Z0-9]{6,}$";
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        String regexEmail = "^[a-zA-Z0-9]{6,}@gmail.com$";
        String regexPhone = "^0[0-9]{9,}$";

        String text = "";
        String str;
        long ID;
        Pattern pattern;
        boolean check = true;

        System.out.print("Enter your ID: ");
        ID = scanner.nextInt();
        text += ID + "|";

        scanner.nextLine();
        System.out.print("Enter your full name: ");
        str = scanner.nextLine();
        text += str + "|";

        pattern = Pattern.compile(regexUser);
        System.out.print("Enter username: ");
        do {
            str = scanner.nextLine();
            if (pattern.matcher(str).find() == false) {
                System.out.println("Enter your username again!!");
                System.out.print("Here: ");
            }
        } while (pattern.matcher(str).find() == false);

        text += str + "|";

        pattern = Pattern.compile(regexPassword);
        System.out.print("Enter your password: ");
        do {
            str = scanner.nextLine();
            if (pattern.matcher(str).find() == false) {
                System.out.println("Enter your password again!!");
                System.out.print("Here: ");
            }
        } while (pattern.matcher(str).find() == false);

        System.out.print("Enter your re password: ");
        String rePassword;
        do {
            rePassword = scanner.nextLine();
            if (str.compareTo(rePassword) != 0) {
                System.out.println("Enter your re password again!!");
                System.out.print("Here: ");
            }
        } while (str.compareTo(rePassword) != 0);

        text += str + "|";

        pattern = Pattern.compile(regexEmail);
        System.out.print("Enter your email: ");
        do {
            str = scanner.nextLine();
            if (pattern.matcher(str).find() == false) {
                System.out.println("Enter your email again!!");
                System.out.print("Here: ");
            }
        } while (pattern.matcher(str).find() == false);

        text += str + "|";

        pattern = Pattern.compile(regexPhone);
        System.out.print("Enter your phone number: ");
        do {
            str = scanner.nextLine();
            if (pattern.matcher(str).find() == false) {
                System.out.println("Enter your phone number again!!");
                System.out.print("Here: ");
            }
        } while (pattern.matcher(str).find() == false);

        text += str + "|";

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        str = simpleDateFormat.format(date);

        text += str;


        WriteFile("ACC.DAT", text);
    }

    private static void WriteFile(String fileName, String str) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        printWriter.println(str);

        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    private static void LoginToAnExistingAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("LOG IN");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (CheckAccount("ACC.DAT", username, password)) {
            System.out.println("Log in successful!!");
            int selection;
            do {
                System.out.println("---------------------------");
                System.out.println("1. Show information.");
                System.out.println("2. Change password.");
                System.out.println("---------------------------");
                System.out.print("Enter your selection: ");
                selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        ShowInformationAccount(username);
                        break;
                    case 2:
                        ChangePassword(username);
                        break;
                }
            } while (selection < 1 || selection > 2);

        } else
            System.out.println("Username or Password is wrong. Log in fail!!");
    }


    private static void ShowInformationAccount(String username) {
        System.out.println("YOUR INFORMATION: ");
        try {
            Scanner scanner = new Scanner(Paths.get("ACC.DAT"));
            while (scanner.hasNext()) {
                String[] a = scanner.nextLine().split("\\|");
                if (a[2].compareTo(username) == 0) {
                    System.out.println("ID: " + a[0]);
                    System.out.println("Full name: " + a[1]);
                    System.out.println("Username: " + a[2]);
                    System.out.println("Email: " + a[4]);
                    System.out.println("Phone: " + a[5]);
                    System.out.println("Create at: " + a[6]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ChangePassword(String username) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        try {
            Scanner scannerVer2 = new Scanner(Paths.get("ACC.DAT"));
            while (scannerVer2.hasNext()) {
                String inforChange = scannerVer2.nextLine();
                String[] a = inforChange.split("\\|");
                if (a[2].compareTo(username) == 0) {
                    String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                    Pattern pattern = Pattern.compile(regexPassword);
                    String str;
                    System.out.print("Enter your new password: ");
                    do {
                        str = scanner.nextLine();
                        if (pattern.matcher(str).find() == false) {
                            System.out.println("Enter your new password again!!");
                            System.out.print("Here: ");
                        }
                    } while (pattern.matcher(str).find() == false);

                    System.out.print("Enter your re password: ");
                    String rePassword;
                    do {
                        rePassword = scanner.nextLine();
                        if (str.compareTo(rePassword) != 0) {
                            System.out.println("Enter your re password again!!");
                            System.out.print("Here: ");
                        }
                    } while (str.compareTo(rePassword) != 0);
                    System.out.println("Change password successful!!");
                    a[3] = str;
                    inforChange = "";
                    for (int i = 0; i < a.length; i++) {
                        inforChange += a[i];
                        if (i < a.length - 1)
                            inforChange += "|";
                    }
                }
                list.add(inforChange);
            }
            scannerVer2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReWriteFile("ACC.DAT", list);
    }

    private static void ReWriteFile(String fileName, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter("ACC.DAT", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            for (String x : list) {
                printWriter.println(x);
            }

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean CheckAccount(String fileName, String username, String password) {
        try {
            Scanner scanner = new Scanner(Paths.get(fileName));
            while (scanner.hasNext()) {
                String[] a = scanner.nextLine().split("\\|");
                if (a[2].compareTo(username) == 0 && a[3].compareTo(password) == 0)
                    return true;
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void SortAccountByUsername() {
        try {
            Scanner scanner = new Scanner(Paths.get("ACC.DAT"));
            List<String> list = new ArrayList<>();
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            for (int i = 0; i < list.size() - 1; i++) {
                for(int j= list.size()-1; j>i; j--){
                    String[] a1 = list.get(j-1).split("\\|");
                    String[] a2 = list.get(j).split("\\|");
                    if(a1[2].compareTo(a2[2]) > 0){
                        String temp = list.get(j-1);
                        list.set(j-1, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
            System.out.println("---------------------------------------------");
            System.out.println("ACCOUNT");
            System.out.printf("%20s %20s %20s %30s %20s %20s\n", "ID", "Full name", "Username", "Email", "Phone Number", "Time create");
            for(String x : list){
                String[] a = x.split("\\|");
                System.out.printf("%20s %20s %20s %30s %20s %20s\n", a[0], a[1], a[2], a[4], a[5], a[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    private static boolean CheckUsername(String fileName, String username) throws IOException {
//        Scanner scanner = new Scanner(Paths.get(fileName));
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            String[] x = str.split("\\|");
//            for (int i = 0; i < x.length; i++) {
//                if (x[2].compareTo(username) == 0)
//                    return true;
//            }
//        }
//        return false;
//    }

//    private static int IDMax(String fileName) throws IOException {
//        List<String> list = new ArrayList<>();
//        int max = 0;
//        Scanner scanner = new Scanner(Paths.get(fileName));
//        while (scanner.hasNext()) {
//            list.add(scanner.nextLine());
//        }
//        scanner.close();
//
//        String[] x = list.get(0).split("\\|");
//        max = Integer.parseInt(x[0]);
//        for (int i = 0; i < list.size(); i++) {
//            x = list.get(i).split("\\|");
//            int temp = Integer.parseInt(x[0]);
//            if (max < temp)
//                max = temp;
//        }
//        return max;
//    }
}
