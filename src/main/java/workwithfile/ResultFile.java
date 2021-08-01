package workwithfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    @SuppressWarnings({"checkstyle:EmptyBlock", "checkstyle:WhitespaceAfter"})
    public static void main(String[] args) {
        try (FileOutputStream file = new FileOutputStream("result.txt");
             FileInputStream fRead = new FileInputStream("result.txt")) {
            String str = "login=login\n"
                    + "password=password\n"
                    + "url=url";
            file.write(str.getBytes());
            System.out.println("========= done =========");
            int s;
            StringBuilder text = new StringBuilder();
            while ((s = fRead.read()) == -1) {
                text.append((char) s);
            }
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
