package Lesson_5_2;

import java.util.Scanner;

public class Information {
    private String name;
    private Date born;
    private String gender;
    private Hobby hobby;

    public Information() {

    }

    public Information(String name, Date born, String gender, Hobby hobby) {
        this.name = name;
        this.born = born;
        this.gender = gender;
        this.hobby = hobby;
    }

    public void SetInfor() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter Date: ");
        born = new Date();
        born.InpututDate();
        System.out.printf("Enter gender: ");
        this.gender = scanner.nextLine();
        System.out.println("Enter your hobby: ");
        hobby = new Hobby();
        hobby.InputHobby();
    }

    public void ShowInfor(int i) {
        System.out.println("STT: " + (i + 1));
        System.out.println("Name: " + name);
        System.out.println("Date: " + born.toString());
        System.out.println("Gender: " + gender);
        System.out.println("Hobby: " + hobby.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }
}



