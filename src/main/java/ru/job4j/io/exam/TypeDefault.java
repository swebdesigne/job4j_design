package ru.job4j.io.exam;

import java.nio.file.Path;

public class TypeDefault implements ISearch {

    String file;
    public TypeDefault(String file) {
        this.file = file;
    }

    @Override
    public boolean search(Path path) {
        return path.toFile().getName().equals(this.file);
    }
}
