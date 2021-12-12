package ru.job4j.mio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileEx {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("test1_3242.txt");
        file.createNewFile();
        File path = new File(".");
        File[] s = path.listFiles();
        for (File f : s) {
            if (f.isDirectory()) {
                System.out.println(f.getName());
                File[] innerF = f.listFiles();
                for (File iff : innerF) {
                    if (iff.isDirectory()) {
                        System.out.println("\t" + iff.getName());
                    }
                }
            }
        }
        System.out.println(file.exists());
        Thread.sleep(4000);
        file.delete();
        System.out.println(file.exists());
        try (FileChannel ch = new FileInputStream("w_rubai.txt").getChannel()
        ) {
            ByteBuffer bf = ByteBuffer.allocate(100);
            StringBuilder sb = new StringBuilder();
            while (bf.hasRemaining()) {
                sb.append((char) bf.get());
            }
            System.out.println(sb);
        }
    }
}
