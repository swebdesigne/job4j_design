package ru.job4j.mio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    private void fileReader(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            int b;
            StringBuilder sb = new StringBuilder();
            while ((b = fr.read()) != -1) {
                sb.append((char) b);
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileReaderEx fre = new FileReaderEx();
        fre.fileReader("w_rubai.txt");
    }
}
