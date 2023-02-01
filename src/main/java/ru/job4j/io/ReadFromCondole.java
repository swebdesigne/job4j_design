package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ReadFromCondole {
    public String readFromConsole() {
        StringBuilder result = new StringBuilder();
        try (java.io.BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String str = "";
            while (!Objects.equals(str = bfr.readLine(), "close")) {
                result.append(str).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        var readFromConsole = new ReadFromCondole();
        System.out.println(readFromConsole.readFromConsole());
    }
}
