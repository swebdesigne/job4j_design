package ru.job4j.mio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try (FileChannel fc = new FileOutputStream("data.txt").getChannel();
             FileChannel rc = new RandomAccessFile("data.txt", "rw").getChannel();
             FileChannel fi = new FileInputStream("data.txt").getChannel()
        ) {
            fc.write(ByteBuffer.wrap("Some text\n".getBytes(StandardCharsets.UTF_8)));
            rc.position(fc.size());
            rc.write(ByteBuffer.wrap("Some more".getBytes(StandardCharsets.UTF_8)));
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fi.read(buff);
            buff.flip();
            StringBuilder sb = new StringBuilder();
            while (buff.hasRemaining()) {
                sb.append((char) buff.get());
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
