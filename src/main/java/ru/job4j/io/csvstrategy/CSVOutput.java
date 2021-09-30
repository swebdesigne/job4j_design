package ru.job4j.io.csvstrategy;

public class CSVOutput {
    CSVWrite output;

    public CSVOutput(CSVWrite output) {
        this.output = output;
    }

    public void output(StringBuilder reader, String path) {
        output.output(reader, path);
    }
}
