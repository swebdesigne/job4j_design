package ru.job4j.mio;

import java.io.*;

public class BufferedInputFile {
    /**
     * the method is reading the file by strings
     * @param fileName - name file
     * @return
     * @throws IOException
     */
    public static String read(String fileName) {
        StringBuilder sb =  new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s + "\n");
           }
       } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(read("text10.txt"));
    }
}
