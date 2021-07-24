package workwithfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\beelk\\OneDrive\\Рабочий стол\\order_1618313645.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("order_1618313645.jpg")) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                fileOutputStream.write(ch);
            }
            System.out.println("done");
        }
    }
}
