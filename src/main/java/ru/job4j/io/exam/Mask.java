package ru.job4j.io.exam;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Mask implements ISearch {
    String file;
    private Pattern pattern;

    public Mask(String file) {
        this.file = file;
        pattern = Pattern.compile(file);
    }

    @Override
    public boolean search(Path path) {
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).find();
            }
        };
        return filenameFilter.accept(path.toFile(), path.toFile().getName());
    }
}
