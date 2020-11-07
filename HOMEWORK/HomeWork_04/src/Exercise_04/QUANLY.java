package Lesson_04;

import java.util.Scanner;

public class QUANLY {
    private String codeManager;
    private String fullName;

    public void InputManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code manager: ");
        this.codeManager = scanner.nextLine();
        System.out.printf("Enter full name: ");
        this.fullName = scanner.nextLine();
    }
    public void ShowManager(){
        System.out.println("Code manager: " + this.codeManager);
        System.out.println("Manager: " + this.fullName);
    }

    public String getCodeManager() {
        return codeManager;
    }

    public void setCodeManager(String codeManager) {
        this.codeManager = codeManager;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
