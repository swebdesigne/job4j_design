package job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedReader {
    public static List<String> filter(String file) {
        try (FileReader reader = new FileReader(file);
             java.io.BufferedReader in = new java.io.BufferedReader(reader)) {
            return in.lines()
                    .filter(x -> Integer.parseInt(x.split(" ")[8]) == 404)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void save(List<String> list, String error) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(error)))) {
            for (String line :list) {
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
