package ru.job4j.io;

import java.util.List;

import static java.lang.System.out;

public class Out implements Bot {
    @Override
    public void doIt(ConsoleChat chat, String output) {
        out.println("Пока! Пока!");
        chat.saveLog(List.of(output, "\t" + "Пока! Пока!"));
    }
}
