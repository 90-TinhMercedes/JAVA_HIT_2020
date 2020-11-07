package Lesson_03;

import java.util.Scanner;

public class DateTime {
    private int day;
    private int month;
    private int year;

    public DateTime() {

    }

    public void inputDateTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter date time (dd/mm/yyyy): ");
        this.day = scanner.nextInt();
        this.month = scanner.nextInt();
        this.year = scanner.nextInt();
    }

    public void showDateTime() {
        System.out.print(this.day + "/" + this.month + "/" + this.year + "\n");
    }

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
