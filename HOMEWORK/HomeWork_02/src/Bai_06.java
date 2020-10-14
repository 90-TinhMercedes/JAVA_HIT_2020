import java.util.Scanner;

public class Bai_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String result = "";
        str = str.trim(); // xóa khoảng trắng ở đầu và cuối chuỗi

        // xóa khoảng trắng giữa các từ trong chuỗi
        while (str.contains("  ")){ // str.contains("  ") có thể được thay thế bởi str.indexOf("  ") != -1
            str = str.replace("  ", " ");
        }
        String[] arrString = str.split(" "); // tách chuỗi tại dấu cách và trả về mảng chuỗi
        for (int i = 0; i < arrString.length; i++){ // chuẩn hóa các kí tự đầu mỗi từ thành kí tự hoa
            result += Character.toUpperCase(arrString[i].charAt(0)) + arrString[i].substring(1);
            if(i < arrString.length - 1){
                result += " ";
            }
        }
        System.out.println(result);
    }
}

