package ru.job4j.io.exam;

import java.nio.file.Path;

public class Mask implements ISearch {
    String pattern;

    public Mask(String file) {
        this.pattern = file;
    }

    /**
     * метод ищет файл по маске, например - .txt
     * @param path - путь к файлу
     * @return - возвращает true или false
    */
    @Override
    public boolean search(Path path) {
        return path.toFile().getName().endsWith(pattern);
    }
}
