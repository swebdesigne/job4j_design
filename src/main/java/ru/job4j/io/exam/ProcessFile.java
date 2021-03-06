package ru.job4j.io.exam;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 *  Класс ищет файлы в указанной директории и записыает в лог
 *  @author IGOR SIVOLOBOV
 *  @version 1.0
*/
public class ProcessFile {
    private final String log;
    private final String dir;
    private final String file;
    private final String[] args;
    private final String pattern;
    private static final String MASK = "mask";
    private static final String REGEX = "regex";
    private final Map<String, String> values = new HashMap<>();

    public ProcessFile(String[] args) {
        getArgs(args);
        this.args = args;
        this.log = this.get("o");
        this.dir = this.get("d");
        this.file = this.get("n");
        this.pattern = this.get("t");
        validation();
    }

    /**
     * метод выбирает тип поиска
     * @return
    */
    private Searcher searcher() {
        return Map.of(
                MASK, new Searcher(new Mask(this.file)),
                REGEX,  new Searcher(new Regex(this.file))
        ).getOrDefault(this.pattern, new Searcher(new TypeDefault(this.file)));
    }

    /**
     * метод проходит по директории и находит файл по шаблону
     * @return - возвращает найденные файлы
     * @throws IOException
    */
    private List<Path> search() throws IOException {
        Search searcher = new Search(searcher());
        Files.walkFileTree(Path.of(this.dir), searcher);
        return searcher.getPaths();
    }

    /**
     * метод записывает в файл лог
     * @param path - данные (пути) для записи в лог
    */
    private void writeToFile(List<Path> path) {
        try (FileWriter wr = new FileWriter(this.log)) {
            for (Path text : path) {
                System.out.println(String.valueOf(text));
                wr.write(String.valueOf(text) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * -d=. -n=.*\\bot\\.*txt -t=regex -o=src/main/java/ru/job4j/io/exam/log.txt
    */
    private void validation() {
        if (this.args.length != 4 || (Files.notExists(Path.of(this.log)) || !Files.isDirectory(Path.of(this.dir)))) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    private String get(String key) {
        return values.get(key);
    }

    /**
     * метод разбивает аргументы на наименование и значение
     * заполняет мапу
    */
    private void getArgs(String[] args) {
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
        ProcessFile processFile = new ProcessFile(args);
        processFile.writeToFile(processFile.search());
    }
}
