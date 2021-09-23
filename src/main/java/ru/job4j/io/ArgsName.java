package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    public String getPath() {
        return values.get("d");
    }

    public int size() {
        return values.size();
    }

    public String exclude() {
        return values.get("e");
    }

    public String toDirection() {
        return values.get("o");
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String value : args) {
            if (!displayError("[a-zA-Z0-9*.]=[a-zA-Z0-9*.]", value)) {
                throw new IllegalArgumentException("The string cannot contains no one of the symbol before and after the sign equals");
            }
            String[] tmp = value.split("=");
            values.put(tmp[0].substring(1), tmp[1]);
        }
    }

    private boolean displayError(String pattern, String string) {
        return Pattern.compile(pattern).matcher(string).find();
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}