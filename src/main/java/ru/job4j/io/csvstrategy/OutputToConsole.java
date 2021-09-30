package ru.job4j.io.csvstrategy;

import ru.job4j.io.CSVReader;

public class OutputToConsole implements CSVWrite {
    @Override
    public void output(CSVReader result) {
        System.out.println(result.getResult());
    }
}
