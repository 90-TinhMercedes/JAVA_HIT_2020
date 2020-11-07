package Lesson_05;

import java.util.Scanner;

public class Student extends Person {
    private String studentCode;
    private String major;
    private int level;

    public Student() {

    }

    @Override
    public void inputStudent() {
        Scanner scanner = new Scanner(System.in);
        super.inputPerson();
        System.out.print("Enter student code: ");
        this.studentCode = scanner.nextLine();
        System.out.print("Enter major: ");
        this.major = scanner.nextLine();
        System.out.print("Enter student level: ");
        this.level = scanner.nextInt();
        scanner.nextLine();
    }

    @Override
    public void showStudent() {
        super.showPerson();
        System.out.printf("%20s %20s %20d\n", this.studentCode, this.major, this.level);
    }

    public Student(String studentCode) {
        this.studentCode = studentCode;
    }

    public Student(String fullName, String date, String homeTown, String studentCode) {
        super(fullName, date, homeTown);
        this.studentCode = studentCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
