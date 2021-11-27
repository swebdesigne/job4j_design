package ru.job4j.mio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[] {1, 334, 11, 31});
        System.out.println(ib.get(1));
        ib.put(3, 31231);
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
