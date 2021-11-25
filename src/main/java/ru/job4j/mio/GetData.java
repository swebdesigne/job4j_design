package ru.job4j.mio;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bf.limit()) {
            if (bf.get() != 0) {
                System.out.println("nonzero");
            }
            System.out.println("i = " + i);
            bf.rewind();
            bf.asCharBuffer().put("Howdy!");
            char c;
            while ((c = bf.getChar()) != 0) {
                System.out.println(c + " ");
            }
            System.out.println(" ");
            bf.rewind();
            bf.asShortBuffer().put((short) 471143);
            System.out.println(bf.getShort());
            bf.rewind();
            bf.asIntBuffer().put(31231321);
            System.out.println(bf.getInt());
            bf.rewind();
            bf.asLongBuffer().put(989009013);
            System.out.println(bf.getLong());
            bf.rewind();
        }
    }
}
