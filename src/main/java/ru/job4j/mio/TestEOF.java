package ru.job4j.mio;

import java.io.*;

public class TestEOF {

    /**
     * the first method reads the file by chars
     * the second method reads the file by byte
     * @param args - the input arguments
     */
    public static void main(String[] args) {
        try (FileReader wr = new FileReader("text10.txt");
             BufferedReader bw = new BufferedReader(wr)
        ) {
            String ch;
            System.out.println("========================== BEGIN FIRST =================================");
            while ((ch = bw.readLine()) != null) {
                System.out.println(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("text10.txt"))
        )) {
            StringBuilder sb = new StringBuilder();
            System.out.println("=========================== BEGIN SECOND ================================");
            while (in.available() != 0) {
                sb.append((char) in.readByte());
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
