package ru.job4j.mio;

import java.io.*;

public class StoringAndRecoveringData {
    private void writer() {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("data.txt")));
        ) {
            out.writeDouble(3.123);
            out.writeUTF("output into file data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reader() {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("data.txt"))
        )
        ) {
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StoringAndRecoveringData file = new StoringAndRecoveringData();
        file.writer();
        file.reader();
    }
}
