package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (FileReader fileReader = new FileReader(this.path);
                BufferedReader read = new BufferedReader(fileReader)) {
            Iterator<String> iterator = read.lines().iterator();
            while (iterator.hasNext()) {
                String tmp = iterator.next();
                if (displayError("=[^a-zA-Z0-9]", tmp) || displayError("[^a-zA-Z0-9]=", tmp)) {
                    throw new IllegalArgumentException("The string cannot contains no one of the symbol before and after the sign equals");
                }
                if (!tmp.startsWith("#") && !tmp.isEmpty()) {
                    String[] explodeString = tmp.split("=");
                    values.put(explodeString[0], (explodeString.length < 2) ? null : explodeString[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean displayError(String pattern, String string) {
        return Pattern.compile(pattern).matcher(string).find();
    }

    public String value(String key) {
        return values.get(key);
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("src/main/java/data/app.properties"));
    }
}
