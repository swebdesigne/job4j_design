package ru.job4j.io.exam;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class Mask implements ISearch {
    String pattern;

    public Mask(String pattern) {
        this.pattern = pattern.replace("?", ".?")
        .replace("*", ".*?");
    }

    /**
     * метод ищет файл по маске, например - .txt
     * @param path - путь к файлу
     * @return - возвращает true или false
    */
    @Override
    public boolean search(Path path) {
        return Pattern.compile(pattern).matcher(path.toString()).find();
    }
}
