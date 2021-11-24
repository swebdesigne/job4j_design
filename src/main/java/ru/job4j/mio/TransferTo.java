package ru.job4j.mio;

import java.io.*;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String ch;
            while ((ch = bf.readLine()) != null) {
                System.out.println(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (args.length != 2) {
            System.out.println("arguments: source file dest file");
            System.exit(1);
        }
        try (FileChannel in = new FileInputStream(args[0]).getChannel();
            FileChannel out = new FileOutputStream(args[1]).getChannel()
        ) {
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
