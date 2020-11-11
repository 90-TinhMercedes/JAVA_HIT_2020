package Problem;

import java.util.Scanner;

public class problem_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        n = n / 5;
        long ans = n;
        while (n / 5 > 0) {
            n = n / 5;
            ans += n;
        }
        System.out.println(ans);
    }
}
