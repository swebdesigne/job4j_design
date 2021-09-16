package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        Search s = new Search();
        s.validation(args);
        Path start = Paths.get(args[0]);
        s.search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }
    private void validation(String[] args) {
        if (args.length != 2 || (Files.notExists(Path.of(args[0])) || !Files.isDirectory(Path.of(args[0])))) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }
    public List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
