package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> set = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       if (!set.add(new FileProperty(attrs.size(), String.valueOf(file.getFileName())))) {
                System.out.println(String.format("fileName = %s size = %s", file.getFileName(), attrs.size()));
        }
        return super.visitFile(file, attrs);
    }
}
