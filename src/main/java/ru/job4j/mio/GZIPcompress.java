package ru.job4j.mio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public void writeToFile() {
        try (BufferedReader in = new BufferedReader(new FileReader("text10.txt", StandardCharsets.UTF_8));
             BufferedOutputStream out = new BufferedOutputStream(
                     new GZIPOutputStream(new FileOutputStream("GZIPOutputStream.txt")
                     )
             )
        ) {
            System.out.println("Writing file");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            System.out.println("Read file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (BufferedReader in2 = new BufferedReader(new InputStreamReader(
                new GZIPInputStream(new FileInputStream("GZIPOutputStream.txt"))
        ))) {
            String s;
            while ((s = in2.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GZIPcompress gz = new GZIPcompress();
        gz.writeToFile();
        gz.readFromFile();
    }
}
