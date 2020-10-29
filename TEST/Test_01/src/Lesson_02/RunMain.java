package Lesson_02;

import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Book> list = new ArrayList<>();
    public static int n;

    public static void main(String[] args) {
        do {
            System.out.println("/****************************************/");
            System.out.println("OPTION:");
            System.out.println("1. Add book.");
            System.out.println("2. Edit book by id.");
            System.out.println("3. Delete book by id.");
            System.out.println("4. Sort book by name (ascending).");
            System.out.println("5. Sort book by price (descending).");
            System.out.println("6. Show all books.");
            System.out.println("0. Exit.");
            System.out.println("/****************************************/");
            System.out.printf("Enter your selection: ");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    AddBook();
                    break;
                case 2:
                    EditBookByID();
                    break;
                case 3:
                    DeleteBookByID();
                    break;
                case 4:
                    SortBookByName();
                    break;
                case 5:
                    SortBookByPrice();
                    break;
                case 6:
                    ShowBookList();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Oh no, you can enter selection in [0..6]");
            }
        } while (true);
    }

    public static void AddBook() {
        System.out.printf("Enter amount of book you need add: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter information book " + (i + 1) + "");
            Book book = new Book();
            book.inputBook();
            list.add(book);
        }
    }

    public static void EditBookByID() {
        if (list.size() == 0)
            System.out.println("Oh no, book list is empty!!");
        else {
            System.out.printf("Enter ID you need fix: ");
            scanner.nextLine();
            String fixID = scanner.nextLine();
            int count = 0;
            int location = 0;
            for (Book i : list) {
                if (i.getID().compareTo(fixID) == 0) {
                    location = list.indexOf(i);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Oh no, ID you need fix not found!");
            } else {
                Book book = new Book();
                book.inputBook();
                list.remove(location);
                list.add(location, book);
                System.out.println("Edit book successful!");
            }
        }
    }

    public static void DeleteBookByID() {
        if (list.size() == 0)
            System.out.println("Oh no, book list is empty!!");
        else {
            System.out.printf("Enter ID you need delete: ");
            scanner.nextLine();
            String deleteID = scanner.nextLine();
            int count = 0;
            int location = 0;
            for (Book i : list) {
                if (i.getID().compareTo(deleteID) == 0) {
                    location = list.indexOf(i);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Oh no, ID you need delete not found!");
            } else {
                Book book = new Book();
                list.remove(location);
                System.out.println("Delete book successful!");
            }
        }
    }

    public static void SortBookByName() {
        if (list.size() == 0)
            System.out.println("Oh no, book list is empty!!");
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getName().compareToIgnoreCase(list.get(i + 1).getName()) > 0) {
                    Book temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
                System.out.println("Sort by name (ascending) successfull!");
            }
        }
    }

    public static void SortBookByPrice() {
        if (list.size() == 0)
            System.out.println("Oh no, book list is empty!!");
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getPrice() < list.get(i + 1).getPrice()) {
                    Book temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
                System.out.println("Sort by price (descending) successfull!");
            }
        }
    }

    public static void ShowBookList() {
        if (list.size() == 0)
            System.out.println("Oh no, book list is empty!!");
        else {
            Title();
            for (Book i : list)
                i.outputBook();
        }
    }

    public static void Title() {
        System.out.printf("%20s %20s %20s %20s %20s %20s\n", "ID", "Book", "Publisher", "Price", "Page", "Author");
    }
}
