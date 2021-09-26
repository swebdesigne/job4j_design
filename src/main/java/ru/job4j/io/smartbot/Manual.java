package ru.job4j.io.smartbot;

import ru.job4j.io.ConsoleChat;
import ru.job4j.io.smartbot.Bot;

import java.io.IOException;
import java.util.List;

public class Manual implements Bot {
    @Override
    public void doIt(ConsoleChat chat, String output) throws IOException {
        List.of(
                "1. Стоп - тишина",
                "2. Продолжить - возобновить общение",
                "3. Закончить - выход из чата"
        ).forEach(System.out::println);
        chat.run();
    }
}
