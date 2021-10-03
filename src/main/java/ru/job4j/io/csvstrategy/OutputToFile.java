package ru.job4j.io.csvstrategy;

import ru.job4j.io.CSVReader;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class OutputToFile implements CSVWrite {
    @Override
    public void output(CSVReader result) {
        try (FileWriter writer = new FileWriter(String.valueOf(result.getOut()), StandardCharsets.UTF_8)) {
            writer.write(String.valueOf(result.getResult()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
