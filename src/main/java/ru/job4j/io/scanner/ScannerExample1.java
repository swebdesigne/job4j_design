package ru.job4j.io.scanner;

import java.io.CharArrayReader;
import java.util.Scanner;

public class ScannerExample1 {
    public static void main(String[] args) {
        var ls = System.lineSeparator();
        var data = String.join(ls,
                "1 2 3",
                "4 5 6",
                "7 8 9 "
        );
        System.out.println(data);
        var scanner = new Scanner(new CharArrayReader(data.toCharArray()));
        while (scanner.hasNext()) {
            System.out.println(scanner.nextInt());
            System.out.println(" ");
        }
    }
}
