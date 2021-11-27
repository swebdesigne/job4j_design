package ru.job4j.question;

import java.nio.ByteBuffer;

public class ViewBuffers {
    private static void display(ByteBuffer bb) {
        while (bb.hasRemaining()) {
            System.out.println(bb.position() + " -> " + bb.get() + ", ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[] {0, 0, 0, 0, 'a'});
        bb.rewind();
        System.out.println("Byte buffer ");
        display(bb);
    }
}
