package Lesson_5_2;

import java.util.Scanner;

public class Hobby {
    private String morning;
    private String affternoon;

    public Hobby() {

    }

    public void InputHobby() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your hobby in morning: ");
        this.morning = scanner.nextLine();
        System.out.printf("Enter your hobby in affternoon: ");
        this.affternoon = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Morning: " + morning + ", Affternoon: " + affternoon;
    }

    public Hobby(String morning, String affternoon) {
        this.morning = morning;
        this.affternoon = affternoon;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getAffternoon() {
        return affternoon;
    }

    public void setAffternoon(String affternoon) {
        this.affternoon = affternoon;
    }
}

