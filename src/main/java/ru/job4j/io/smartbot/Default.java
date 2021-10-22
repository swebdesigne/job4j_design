package ru.job4j.io.smartbot;

import ru.job4j.io.ConsoleChat;

import java.io.IOException;
import java.util.List;
import static java.lang.System.out;

public class Default implements Bot {
    @Override
    public void doIt(ConsoleChat chat, String output) throws IOException {
        String answer = chat.readPhrases();
        out.println(answer);
        chat.saveLog(List.of(output, "\t" + answer));
        chat.run();
    }
}
