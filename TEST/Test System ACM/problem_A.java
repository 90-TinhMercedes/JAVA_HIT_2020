package Problem;

import java.util.Scanner;

public class problem_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ans = 0;
        int n;
        int a[] = new int[200007];
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 2; i <= n; i++) {
            if (a[i] < a[i - 1]) {
                ans += a[i - 1] - a[i];
                a[i] = a[i - 1];
            }
        }
        System.out.println(ans);
    }
}
