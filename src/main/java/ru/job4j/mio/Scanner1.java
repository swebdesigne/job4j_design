package ru.job4j.mio;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int i = scanner.nextInt();
        System.out.println("was entered the number: " + i);
        System.out.println("write the two numbers");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("x / y: " + (x / y));
        System.out.println("Write the couple strings");
        String str = scanner.nextLine();
        System.out.println("String equals: " + str);
        Scanner s = new Scanner("Hello my friend");
        Scanner str = s.useDelimiter(" ");
        System.out.println(str.next());
        while (str.hasNext()) {
            System.out.println(str.next());
        }
    }
}
