package Account_Rework;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date;
    static Pattern pattern;

    static DataController dataController = new DataController();
    static List<Account> list = new ArrayList<>();

    static final String regexUsername = "^[0-9a-zA-Z]{6,}$";
    static final String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?])[a-zA-Z0-9!@#$%^&*?]{8,}$";
    static final String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    static final String regexPhone = "^[0-9\\-\\+]{9,}$";

    static final String accountFileName = "account.DAT";

    public static void main(String[] args) {
        int selection;
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("OPTION");
            System.out.println("1. Create new account.");
            System.out.println("2. Login to an existing account.");
            System.out.println("3. Sort accounts by username.");
            System.out.println("4. Exit.");
            System.out.println("-------------------------------------------------------");
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    CreateNewAccount();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    list = dataController.ReadAccountFromFile(accountFileName);
                    Collections.sort(list, new SortAccountsByUsername());
                    dataController.UpdateAccountFile(list, accountFileName);
                    for (Account account : list) {
                        System.out.println(account);
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    private static void CreateNewAccount() {
        long id;
        String fullName, username, password, rePassword, email, phone, createAt;
        boolean checkID, checkUsername, isUsername, isPassword, isEmail, isPhone;
        do {
            System.out.print("Enter your ID: ");
            id = scanner.nextLong();
            checkID = CheckID(id);
            if (CheckID(id)) {
                System.out.print("ID already exists ");
            }
        } while (checkID);

        scanner.nextLine();
        System.out.print("Enter full name: ");
        fullName = scanner.nextLine();

        do {
            System.out.print("Username: ");
            username = scanner.nextLine();
            pattern = Pattern.compile(regexUsername);
            isUsername = pattern.matcher(username).find();

            checkUsername = CheckUsername(username);
            if (!isUsername) {
                System.out.println("Fail, username is invalid!");
            } else {
                if (checkUsername) {
                    System.out.println("Username already exist!");
                }
            }
        } while (checkUsername);

        do {
            System.out.print("Password: ");
            password = scanner.nextLine();
            System.out.print("Confirm password: ");
            rePassword = scanner.nextLine();
            pattern = Pattern.compile(rePassword);
            isPassword = pattern.matcher(password).find();
            if (!isPassword) {
                System.out.println("Fail, password is invalid!");
            } else {
                if (password.compareTo(rePassword) != 0) {
                    System.out.println("Passwords must be the same!");
                } else {
                    break;
                }
            }
        } while (true);

        do {
            System.out.print("Email: ");
            email = scanner.nextLine();
            pattern = Pattern.compile(regexEmail);
            isEmail = pattern.matcher(email).find();
            if (!isEmail) {
                System.out.println("Email is invalid!");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Phone: ");
            phone = scanner.nextLine();
            pattern = Pattern.compile(regexPhone);
            isPhone = pattern.matcher(phone).find();
            if (!isPhone) {
                System.out.println("Phone number is invalid!");
            } else {
                break;
            }
        } while (true);

        date = new Date();
        createAt = simpleDateFormat.format(date);

        Account account = new Account(id, fullName, username, password, email, phone, createAt);
        dataController.WriteAccountToFile(accountFileName, account);
    }

    private static void Login() {
        list = dataController.ReadAccountFromFile(accountFileName);
        int selection;
        String username;
        String password;
        boolean checkAccount = false;

        System.out.print("Username: ");
        scanner.nextLine();
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();

        checkAccount = CheckAccount(username, password);

        if (checkAccount) {
            Account account = GetAccountByUsername(username);
            System.out.println("Login successful!");
            do {
                System.out.println("1. Show information.");
                System.out.println("2. Change password.");
                System.out.println("3. Log out.");
                System.out.print("Enter your selection: ");
                selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println(account);
                        break;
                    case 2:
                        ChangePassword(username, password, account);
                        break;
                    case 3:
                        return;
                }
            } while (true);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static boolean CheckID(long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckUsername(String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().compareTo(username) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckAccount(String username, String password) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().compareTo(username) == 0 && list.get(i).getPassword().compareTo(password) == 0) {
                return true;
            }
        }
        return false;
    }

    private static Account GetAccountByUsername(String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().compareTo(username) == 0) {
                return list.get(i);
            }
        }
        return null;
    }

    private static void ChangePassword(String username, String oldPassword, Account account) {
        String reOldPassword, password, rePassword;
        boolean isPassword;
        scanner.nextLine();
        do {
            System.out.print("Old password: ");
            reOldPassword = scanner.nextLine();

            System.out.print("New password: ");
            password = scanner.nextLine();

            System.out.print("Confirm password: ");
            rePassword = scanner.nextLine();

            pattern = Pattern.compile(regexPassword);
            isPassword = pattern.matcher(password).find();

            if (reOldPassword.compareTo(oldPassword) != 0) {
                System.out.println("Password and old password must be the same!");
            } else {
                if (!isPassword) {
                    System.out.println("Password is invalid!");
                } else {
                    if (password.compareTo(rePassword) != 0) {
                        System.out.println("Password and confirm password must be the same!");
                    } else {
                        break;
                    }
                }
            }
        } while (true);

        account.setPassword(password);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().compareTo(username) == 0) {
                list.set(i, account);
                break;
            }
        }
        dataController.UpdateAccountFile(list, accountFileName);
    }
}
