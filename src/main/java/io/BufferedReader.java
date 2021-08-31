package io;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedReader {
    public static List<String> filter(String file) {
        try (FileReader reader = new FileReader(file);
             java.io.BufferedReader in = new java.io.BufferedReader(reader)) {
            return in.lines()
                    .filter(x -> Integer.valueOf(x.split(" ")[8]) == 404)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.stream().forEach(System.out::println);
    }
}
