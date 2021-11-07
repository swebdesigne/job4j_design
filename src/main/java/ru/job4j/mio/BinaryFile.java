package ru.job4j.mio;

import java.io.*;

public class BinaryFile {
    private static byte[] data;

    public static void read(File bFile) {
        try (BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile))) {
            data = new byte[bf.available()];
            bf.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        read(new File(bFile));
        return data;
    }
}
