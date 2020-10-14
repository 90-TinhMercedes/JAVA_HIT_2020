package Lesson_04;

import java.util.Scanner;

public class PHONGMAY {
    private String codeRoom;
    private String nameRoom;
    private String acreageRoom;
    private QUANLY manager;
    private MAY[] computer;

    public void InputComputerRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter code room: ");
        this.codeRoom = scanner.nextLine();
        System.out.printf("Room: ");
        this.nameRoom = scanner.nextLine();
        System.out.printf("Enter acreage room: ");
        this.acreageRoom = scanner.nextLine();
        System.out.println("Enter information manager: ");
        manager = new QUANLY();
        manager.InputManager();
        int y;
        System.out.printf("Enter amount computer: ");
        y = scanner.nextInt();
        computer = new MAY[y];
        for (int i = 0; i < computer.length; i++) {
            System.out.println("Enter information computer " + (i + 1) + ": ");
            computer[i] = new MAY();
            computer[i].InputComputer();
        }
    }

    public void ShowComputerRoom() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("INFORMATION COMPUTER ROOM");
        System.out.println("Code room: " + this.codeRoom);
        System.out.println("Room: " + this.nameRoom);
        System.out.println("Acreage room: " + this.acreageRoom);
        System.out.println("INFORMATION MANAGER");
        manager.ShowManager();
        System.out.println("INFORMATION COMPUTER");
        for (int i = 0; i < computer.length; i++) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("COMPUTER " + (i + 1) + ": ");
            computer[i].ShowComputer();
        }
    }

    public String getCodeRoom() {
        return codeRoom;
    }

    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getAcreageRoom() {
        return acreageRoom;
    }

    public void setAcreageRoom(String acreageRoom) {
        this.acreageRoom = acreageRoom;
    }

    public QUANLY getManager() {
        return manager;
    }

    public void setManager(QUANLY manager) {
        this.manager = manager;
    }

    public MAY[] getComputer() {
        return computer;
    }

    public void setComputer(MAY[] computer) {
        this.computer = computer;
    }
}
