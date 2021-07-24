package workwithfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader("test2.txt")) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
            System.out.println();
            System.out.println("done");
        }
    }
}
