package Lesson_02;

import java.util.Scanner;

public class NHANSU {
    private String codePersonnel;
    private String fullName;
    private DATE Date;

    public void InputPersonnel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter information personnel");
        System.out.printf("Enter code personnel: ");
        this.codePersonnel = scanner.nextLine();
        System.out.printf("Enter full name: ");
        this.fullName = scanner.nextLine();
        System.out.printf("Enter date (dd/mm/yyyy): ");
        Date = new DATE();
        Date.SetDate();
    }
    public void ShowPersonnel(){
        System.out.println("---------------------------------------------------------");
        System.out.println("INFORMATION: ");
        System.out.println("Code: " + this.codePersonnel);
        System.out.println("Full name: " + this.fullName);
        System.out.printf("Date: " + Date.toString());
    }

    public String getCodePersonnel() {
        return codePersonnel;
    }

    public void setCodePersonnel(String codePersonnel) {
        this.codePersonnel = codePersonnel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DATE getDate() {
        return Date;
    }

    public void setDate(DATE date) {
        Date = date;
    }
}
