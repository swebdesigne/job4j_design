package ru.job4j.io.exam;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements ISearch {
    String pattern;

    public Regex(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean search(Path path) {
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(path.toFile().getName());
        return matcher.find();
    }
}
