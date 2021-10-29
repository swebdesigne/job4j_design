package ru.job4j.io.exam;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class Regex implements ISearch {
    String pattern;

    public Regex(String pattern) {
        this.pattern = pattern;
    }

    /**
     * метод ищет файл по регулярному выражению, например - .*\\bot\\.*txt
     * @param path - путь к файлу
     * @return - возвращает true или false
    */
    @Override
    public boolean search(Path path) {
        return Pattern.compile(pattern).matcher(path.toString()).find();
    }
}
