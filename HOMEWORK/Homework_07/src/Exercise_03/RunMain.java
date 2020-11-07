package Exercise_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<News> list = new ArrayList<>();
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("OPTION");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.println("-----------------------------------------------");

            System.out.print("Enter your selection: ");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("You just request insert news, please!");
                    News x = new News();
                    System.out.print("Enter ID: ");
                    x.setID(scanner.nextInt());
                    System.out.print("Enter title: ");
                    scanner.nextLine();
                    x.setTitle(scanner.nextLine());
                    System.out.print("Enter publish date: ");
                    x.setPublishDate(scanner.nextLine());
                    System.out.print("Enter author: ");
                    x.setAuthor(scanner.nextLine());
                    System.out.print("Enter content: ");
                    x.setContent(scanner.nextLine());
                    System.out.println("Enter 3 rate: ");
                    x.InputRate();
                    System.out.println("Insert successful!");
                    list.add(x);
                    break;
                case 2:
                    if (list.size() == 0) {
                        System.out.println("Oh no, list empty!!!");
                    } else {
                        System.out.println("-----------------------------------------------");
                        System.out.println("LIST NEWS");
                        for (News s : list) {
                            s.Display();
                            System.out.println("-----------------------------------------------");
                        }
                    }
                    break;
                case 3:
                    if (list.size() == 0) {
                        System.out.println("Oh no, list empty!!!");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).Calculate();
                            System.out.println("-----------------------------------------------");
                            list.get(i).Display();
                        }
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
