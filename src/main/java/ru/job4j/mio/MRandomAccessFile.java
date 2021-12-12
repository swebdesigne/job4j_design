package ru.job4j.mio;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MRandomAccessFile {
    public void randomAccessFile() {
        try (RandomAccessFile raf = new RandomAccessFile("w_rubai.txt", "r")) {
            raf.seek(200);
            String s;
            while ((s = raf.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MRandomAccessFile().randomAccessFile();
    }
}
