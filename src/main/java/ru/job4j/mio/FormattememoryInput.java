package ru.job4j.mio;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FormattememoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("text10.txt").getBytes(StandardCharsets.UTF_8)
                    )
            );
            while (true) {
                System.out.println((char) in.readByte());
            }
        } catch (EOFException e) {
            System.out.println(e);
        }
    }
}
