package ru.job4j.io.csvstrategy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OutputToFile implements CSVWrite {
    @Override
    public void output(StringBuilder result, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
