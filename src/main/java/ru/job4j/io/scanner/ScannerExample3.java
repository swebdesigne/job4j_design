package ru.job4j.io.scanner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample3 {
    public static void main(String[] args) throws IOException {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();
        var data = "A 1B FF 110";
        var file = File.createTempFile("data", null);
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(data.getBytes());
        }
        try (var scanner = new Scanner(file).useRadix(16)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextInt());
                System.out.println(" ");
            }
        }
    }
}
