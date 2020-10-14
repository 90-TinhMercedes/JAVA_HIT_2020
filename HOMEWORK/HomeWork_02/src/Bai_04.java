//Bài 04: in image ^^ I am lazy to code request :D

import java.util.Scanner;

public class Bai_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter n: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[" + i + "] = ");
            a[i] = scanner.nextInt();
        }
        int index = 0;
        int S = 0;
        int[] prime = new int[10];
        for (int i = 0; i < 25; i++) {
            if (isPrime(i))
                prime[index++] = i;
        }
        for (int i = 0; i < n; i++) {
            S += (isPrime(a[i]) ? a[i] + prime[i] - i : a[i]);
        }
        System.out.println("Result S = " + S);
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n < 4)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
