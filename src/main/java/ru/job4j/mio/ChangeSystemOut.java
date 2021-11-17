package ru.job4j.mio;


import java.io.PrintWriter;

/**
 * Преобразование System.out в символьный поток PrintWriter
 */
public class ChangeSystemOut {
    public void println(String str) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println(str);
    }
}

class UsingChangeSystemOut {
    public static void main(String[] args) {
        ChangeSystemOut ch = new ChangeSystemOut();
        ch.println("Hello world");
    }
}
