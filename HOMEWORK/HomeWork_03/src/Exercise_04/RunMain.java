package Bai_04;

public class RunMain {
    public static void main(String[] args) {
        Array FirstArray = new Array();
        Array SecondArray = new Array();

        System.out.println("------------------------------------------");
        System.out.println("ENTER YOUR FIRST ARRAY");
        FirstArray.EnterArray();
        System.out.println("------------------------------------------");
        System.out.println("ENTER YOUR SECOND ARRAY");
        SecondArray.EnterArray();
        System.out.println("------------------------------------------");

        System.out.printf("First Array: ");
        FirstArray.Show();
        System.out.printf("Second Array: ");
        SecondArray.Show();
        System.out.println("------------------------------------------");
        double FirstAverage = (FirstArray.Sum() * 1.0) / FirstArray.getN();
        double SecondAverage = (SecondArray.Sum() * 1.0) / SecondArray.getN();

        System.out.printf("Result: ");
        if (FirstAverage > SecondAverage) {
            System.out.println("First average > Second average");
        } else if (FirstAverage < SecondAverage) {
            System.out.println("First average < Second average");
        } else
            System.out.println("Hi");
    }
}
