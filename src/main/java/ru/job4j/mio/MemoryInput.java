package ru.job4j.mio;

import java.io.IOException;
import java.io.StringReader;


public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringBuilder s = new StringBuilder();
        StringReader in = new StringReader(
                BufferedInputFile.read("text10.txt")
        );
        int c;
        while ((c = in.read()) != -1) {
            s.append((char) c);
        }
        System.out.println(s);
    }
}
