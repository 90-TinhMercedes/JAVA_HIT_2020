package ReadFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("loveveigar.txt"));

        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
