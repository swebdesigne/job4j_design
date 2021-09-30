package ru.job4j.io.csvstrategy;

public class OutputToConsole implements CSVWrite {
    @Override
    public void output(StringBuilder csv, String path) {
        System.out.println(csv);
    }
}
