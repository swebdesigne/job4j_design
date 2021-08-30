package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void writeInFile(int size, FileOutputStream out) throws IOException {
        for (int row = 1; row <= size; row++) {
            for (int cell = 1; cell <= size; cell++) {
                out.write(String.valueOf(row + " * " + cell + " = " + row * cell).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (FileOutputStream out  = new FileOutputStream("result.txt")) {
            ResultFile.writeInFile(10, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
