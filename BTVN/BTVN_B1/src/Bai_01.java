import java.util.Scanner;

/* Bài 01: Viết chương trình Java với yêu cầu: Khai báo và khởi tạo hai biến nguyên dương m và n tùy ý.
In ra hình chữ nhật kích thước m x n rỗng bằng các dấu " * ".   */
public class Bai_01 {
    public static void main(String[] args) {
        Scanner add = new Scanner(System.in);
        int m, n;
        System.out.printf("Enter m: ");
        m = add.nextInt();
        System.out.printf("Enter n: ");
        n = add.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == (m - 1) || j == (n - 1)) {
                    System.out.printf(" * ");
                } else {
                    System.out.printf("   ");
                }
            }
            System.out.println();
        }


    }
}
