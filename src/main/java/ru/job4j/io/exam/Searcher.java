package ru.job4j.io.exam;

import java.nio.file.Path;

public class Searcher {
    ISearch search;
    public Searcher(ISearch search) {
        this.search = search;
    }

    public boolean search(Path path) {
        return search.search(path);
    }
}
