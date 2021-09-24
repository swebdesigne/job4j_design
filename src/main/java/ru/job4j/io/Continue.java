package ru.job4j.io;

import java.io.IOException;
import java.util.List;
import static java.lang.System.out;

public class Continue implements Bot {
    @Override
    public void doIt(ConsoleChat chat, String output) throws IOException {
        out.println(chat.readPhrases());
        chat.saveLog(List.of(output, "\t" + chat.readPhrases()));
        chat.run();
    }
}
