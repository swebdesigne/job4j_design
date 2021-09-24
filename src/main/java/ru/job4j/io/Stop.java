package ru.job4j.io;

import java.io.IOException;
import java.util.List;

public class Stop implements Bot {
    @Override
    public void doIt(ConsoleChat chat, String output) throws IOException {
        chat.saveLog(List.of(output));
        chat.run();
    }
}
