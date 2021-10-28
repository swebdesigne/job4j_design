package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ProcessFile {
    private static final String MASK = "mask";
    private static final String REGEX = "regex";
    private final Map<String, String> values = new HashMap<>();

    private Searcher searcher(String file, String type) {
        return Map.of(
                REGEX,  new Searcher(new Regex(file)),
                MASK, new Searcher(new Mask(file))
        ).getOrDefault(type,  new Searcher(new TypeDefault(file)));
    }

    public List<Path> search(Path root, String file, String type) throws IOException {
        Search searcher = new Search(searcher(file, type));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * -d=c:/ -n=*.txt -t=mask -o=log.txt
     * @param args - 1) c:\ 2) java
     */
    private void validation(String[] args) {
        if (args.length != 2 || (Files.notExists(Path.of(args[0])) || !Files.isDirectory(Path.of(args[0])))) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    public String get(String key) {
        return values.get(key);
    }

    private void getArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String value : args) {
            if (!displayError("[[\\S]{0,}]=[[\\S]{0,}]", value)) {
                throw new IllegalArgumentException("The string cannot contains no one of the symbol before and after the sign equals");
            }
            String[] tmp = value.split("=");
            values.put(tmp[0].substring(1), tmp[1]);
        }
    }

    private boolean displayError(String pattern, String string) {
        return Pattern.compile(pattern).matcher(string).find();
    }

    public static void main(String[] args) throws IOException {
        ProcessFile processFile = new ProcessFile();
        processFile.getArgs(args);
        String dir = processFile.get("d");
        String file = processFile.get("n");
        String type = processFile.get("t");
        processFile.search(Paths.get(dir), file, type).forEach(System.out::println);
        s.validation(args);
    }
}
