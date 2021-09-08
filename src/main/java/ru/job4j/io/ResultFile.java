package ru.job4j.io;

import java.io.*;

public class ResultFile {
    public static void writeInFile(int size, PrintWriter out) throws IOException {
        for (int row = 1; row <= size; row++) {
            for (int cell = 1; cell <= size; cell++) {
                out.println(String.valueOf(row + " * " + cell + " = " + row * cell));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream("result.txt")))
        ) {
            ResultFile.writeInFile(10, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
