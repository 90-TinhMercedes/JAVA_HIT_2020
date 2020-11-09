package WriteFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RunMain {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("loveveigar.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        for (int i = 0; i < 3; i++){
            printWriter.println("GFE Love Veigar: " + i);
        }
            printWriter.println("GFE Love Veigar!! Main Veigar");

        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();

    }
}
