package ru.job4j.io.csvstrategy;

public class OutputToConsole implements CSVWrite {
    @Override
    public void output(StringBuilder result, String path) {
        System.out.println(result);
    }
}
