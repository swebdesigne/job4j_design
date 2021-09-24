package ru.job4j.io;

import java.io.IOException;

public class SmartBot {
    Bot bot;

    public SmartBot(Bot bot) {
        this.bot = bot;
    }

    public void execute(ConsoleChat chat, String output) throws IOException {
        bot.doIt(chat, output);
    }
}
