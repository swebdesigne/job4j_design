package ru.job4j.io.smartbot;

import ru.job4j.io.ConsoleChat;

import java.io.IOException;

public interface Bot {
    public void doIt(ConsoleChat chat, String output) throws IOException;
}
