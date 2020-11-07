package Lesson_04;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> list = new ArrayList<>();
    public static int n;

    public static void main(String[] args) {
        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("OPTION: ");
            System.out.println("1. Add student");
            System.out.println("2. Edit student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Sort student by GPA");
            System.out.println("5. Sort student by name");
            System.out.println("6. Show student");
            System.out.println("0. Exit");
            System.out.println("-----------------------------------------------------");
            System.out.printf("Enter your selection: ");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    EditStudentByID();
                    break;
                case 3:
                    DeleteStudentByID();
                    break;
                case 4:
                    SortStudentByGPA();
                    break;
                case 5:
                    SortStudentByName();
                    break;
                case 6:
                    ShowStudent();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Oh no, enter number in option!");
            }
        } while (true);
    }

    public static void AddStudent() {
        System.out.printf("Enter amount of student you need add: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student " + (i + 1) + ": ");
            Student x = new Student();
            x.inputInformation();
            list.add(x);
        }
    }

    public static void EditStudentByID() {
        if (list.size() <= 0)
            System.out.println("Oh no, student list is empty!!");
        else {
            System.out.printf("Enter your ID you need fix: ");
            scanner.nextLine();
            String fixID = scanner.nextLine();
            int count = 0;
            int location = 0;
            for (Student i : list) {
                if (i.getID().compareTo(fixID) == 0) {
                    location = list.indexOf(i);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Oh no, ID you search not found!");
            } else {
                Student x = new Student();
                x.inputInformation();
                list.remove(location);
                list.add(location, x);
                System.out.println("Edit student successful!");
            }
        }

    }

    public static void DeleteStudentByID() {
        if (list.size() <= 0)
            System.out.println("Oh no, student list is empty!!");
        else {
            System.out.print("Enter ID you need remove: ");
            scanner.nextLine();
            String removeID = scanner.nextLine();
            int count = 0;
            int location = 0;
            for (Student i : list) {
                if (i.getID().compareTo(removeID) == 0) {
                    location = list.indexOf(i);
                    count++;
                }
            }
            if (count == 0)
                System.out.println("Oh no, ID you need remove not found!");
            else {
                list.remove(location);
                System.out.println("Remove student successful!");
            }
        }
    }

    public static void SortStudentByGPA() {
        if (list.size() <= 0)
            System.out.println("Oh no, student list is empty!!");
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getGPA() > list.get(i + 1).getGPA()) {
                    Student temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
            System.out.println("Sort by GPA successful!");
        }

    }

    public static void SortStudentByName() {
        if (list.size() <= 0)
            System.out.println("Oh no, student list is empty!!");
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getName().compareToIgnoreCase(list.get(i + 1).getName()) > 0) {
                    Student temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
            System.out.println("Sort by name successful!");
        }
    }

    public static void ShowStudent() {
        if (list.size() <= 0)
            System.out.println("Oh no, student list is empty!!");
        else {
            System.out.printf("%20s %20s %20s %20s %20s", "ID", "Name", "Age", "Address", "GPA\n");
            for (Student i : list)
                i.showInformation();
        }
    }
}
