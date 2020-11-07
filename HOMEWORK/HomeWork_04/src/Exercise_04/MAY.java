package Lesson_04;

import java.util.Scanner;

public class MAY {
    private String codeComputer;
    private String modelComputer;
    private String statusComputer;

    public void InputComputer(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code computer: ");
        this.codeComputer = scanner.nextLine();
        System.out.printf("Enter model computer: ");
        this.modelComputer = scanner.nextLine();
        System.out.printf("Enter status computer: ");
        this.statusComputer = scanner.nextLine();
    }
    public void ShowComputer(){
        System.out.println("Code computer: " + this.codeComputer);
        System.out.println("Model computer: " + this.modelComputer);
        System.out.println("Status computer: " + this.statusComputer);
    }

    public String getCodeComputer() {
        return codeComputer;
    }

    public void setCodeComputer(String codeComputer) {
        this.codeComputer = codeComputer;
    }

    public String getModelComputer() {
        return modelComputer;
    }

    public void setModelComputer(String modelComputer) {
        this.modelComputer = modelComputer;
    }

    public String getStatusComputer() {
        return statusComputer;
    }

    public void setStatusComputer(String statusComputer) {
        this.statusComputer = statusComputer;
    }
}
