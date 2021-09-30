package ru.job4j.io.csvstrategy;

import ru.job4j.io.CSVReader;

public class CSVOutput {
    CSVWrite output;

    public CSVOutput(CSVWrite output) {
        this.output = output;
    }

    public void output(CSVReader result) {
        output.output(result);
    }
}
