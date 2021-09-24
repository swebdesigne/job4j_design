package ru.job4j.io;

import java.io.IOException;

public interface Bot {
    public void doIt(ConsoleChat chat, String output) throws IOException;
}
