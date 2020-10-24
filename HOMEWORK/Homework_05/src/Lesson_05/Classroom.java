package Lesson_05;

import java.util.ArrayList;
import java.util.Scanner;

public class Classroom {
    private String classCode;
    private String className;
    private String openDate;
    private String teacher;
    private ArrayList<Student> x = new ArrayList<>();
    private int n;

    public Classroom() {

    }

    public void inputClassroom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class code: ");
        this.classCode = scanner.nextLine();
        System.out.print("Enter class name: ");
        this.className = scanner.nextLine();
        System.out.print("Enter open date: ");
        this.openDate = scanner.nextLine();
        System.out.print("Enter name's teacher: ");
        this.teacher = scanner.nextLine();
        System.out.print("Enter amount of student: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter information student " + (i + 1) + ": ");
            Student student = new Student();
            student.inputStudent();
            x.add(student);
        }
    }

    public void showClassroom() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("Class code: " + this.classCode);
        System.out.println("Class: " + this.className);
        System.out.println("Open date: " + this.openDate);
        System.out.println("Teacher: " + this.teacher);
        System.out.printf("%20s %20s %20s %20s %20s %20s", "Name", "Date", "Home town", "Code", "Major", "Level\n");
        for (Student i : x)
            i.showStudent();
    }

    public int countK14() {
        int count = 0;
        for (Student i : x) {
            if (i.getLevel() == 14)
                count++;
        }
        return count;
    }

    public void sortByLevel() {
        for (int i = 0; i < x.size() - 1; i++) {
            if (x.get(i).getLevel() > x.get(i + 1).getLevel()) {
                Student temp = x.get(i);
                x.set(i, x.get(i + 1));
                x.set(i + 1, temp);
            }
        }
    }

    public Classroom(String classCode, String className, String openDate, String teacher, ArrayList<Student> x, int n) {
        this.classCode = classCode;
        this.className = className;
        this.openDate = openDate;
        this.teacher = teacher;
        this.x = x;
        this.n = n;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getX() {
        return x;
    }

    public void setX(ArrayList<Student> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
