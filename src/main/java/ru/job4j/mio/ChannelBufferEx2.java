package ru.job4j.mio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("w_rubai.txt", "r");
             FileChannel channel = raf.getChannel()
        ) {
            ByteBuffer bb = ByteBuffer.allocate(25);
            channel.read(bb);
            bb.flip();
            System.out.println((char) bb.get());
            System.out.println((char) bb.get());
            System.out.println((char) bb.get());

            System.out.println((char) bb.get());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
