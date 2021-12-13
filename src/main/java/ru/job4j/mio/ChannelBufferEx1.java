package ru.job4j.mio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelBufferEx1 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("w_rubai.txt", "rw");
             FileChannel channel = raf.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(25);
            StringBuilder stix = new StringBuilder();
            int byteRead = channel.read(buffer);
            while (byteRead > 0) {
                System.out.println("Read: " + byteRead);

                buffer.flip();
                while (buffer.hasRemaining()) {
                    stix.append((char) buffer.get());
                }

                buffer.clear();
                byteRead = channel.read(buffer);
            }
            System.out.println(stix);

            String quote = "\nЕсли человек тебе сделал ЗЛО — ты дай ему конфетку, он тебе ЗЛО — ты ему конфетку... "
                    + "И так до тех пор, пока у этой твари не разовьётся сахарнxый диабет.";

            ByteBuffer bf2 = ByteBuffer.wrap(quote.getBytes(StandardCharsets.UTF_8));
            channel.write(bf2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
