package Exercise_03;

import java.util.Scanner;

public class News implements INews {
    private int ID;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    public News() {

    }

    @Override
    public void Display() {
        System.out.println("ID: " + getID());
        System.out.println("Title: " + getTitle());
        System.out.println("Publish date: " + getPublishDate());
        System.out.println("Author: " + getAuthor());
        System.out.println("Content: " + getContent());
        System.out.println("Average rate: " + getAverageRate());
    }

    public int[] rateList = new int[3];

    public void InputRate() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter rate " + (i + 1) + ": ");
            rateList[i] = scanner.nextInt();
        }
    }

    public void Calculate() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += rateList[i];
        }
        this.averageRate = (float) (sum * 1.0 / 3);
    }

    public News(int ID, String title, String publishDate, String author, String content, float averageRate) {
        this.ID = ID;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
        this.averageRate = averageRate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }


}
