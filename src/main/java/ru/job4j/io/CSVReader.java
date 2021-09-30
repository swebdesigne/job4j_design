package ru.job4j.io;

import ru.job4j.io.csvstrategy.CSVOutput;
import ru.job4j.io.csvstrategy.OutputToConsole;
import ru.job4j.io.csvstrategy.OutputToFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * Класс CSVReader. Задача класса прочитать данные из CSV файла и вывести на консоль либо в файл.
 * @author IGOR SIVOLOBOV
 * @version 1.0
 */
public class CSVReader {
    private final Path path;
    private String delimiter;
    private final String out;
    private final String filter;
    private List<String> columns;
    private StringBuilder result = new StringBuilder();

    /**
     *
     * @param argsName - входные параметры
     */
    public CSVReader(ArgsName argsName) {
        this.out = argsName.get("out");
        this.filter = argsName.get("filter");
        this.path = Path.of(argsName.get("path"));
        this.delimiter = argsName.get("delimiter");
        this.columns = Arrays.asList(filter.split(","));
    }

    public StringBuilder getResult() {
        return result;
    }

    public String getOut() {
        return out;
    }

    /**
     * Метод формирует сторку для вывода
     * Цикл for проходит по строке с заогловками и берет их ключи (порядок),
     * а также формирует строку заголовков
     */
    public void handle() {
        try (Scanner scanner = new Scanner(path)) {
            if (scanner.hasNextLine()) {
                String[] header = scanner.nextLine().split(delimiter);
                List<Integer> keys = new ArrayList<>();
                StringBuilder headers = new StringBuilder();
                for (int i = 0; i < header.length; i++) {
                    if (columns.contains(header[i])) {
                        keys.add(i);
                        headers.append(header[i]).append(delimiter);
                    }
                }
                parseCSVLine(scanner, keys, headers.substring(0, headers.length() - 1));
            }
         } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выводит результат на консоль или в файл
     */
    public void display() {
        Map.of("stdout", new CSVOutput(new OutputToConsole()))
                .getOrDefault(out, new CSVOutput(new OutputToFile())).output(this);
    }

    /**
     * @param scanner - сканнер
     * @param keys - список ключей где хранятся порядковые номера. Нужно для проверки i в цикле while. Если i находится в keys, значит
     *             мы нашли столбец и можем записать занчение столбца в строку
     * @param headers - заголовки
     */
    private void parseCSVLine(Scanner scanner, List<Integer> keys, String headers) {
        result.append(headers);
        while (scanner.hasNext()) {
            int i = 0;
            StringBuilder value = new StringBuilder();
            Scanner line = new Scanner(scanner.nextLine()).useDelimiter(delimiter);
            while (line.hasNextLine()) {
                String tmp = line.next();
                if (keys.contains(i)) {
                    value.append(String.join(System.lineSeparator(), tmp).concat(delimiter));
                }
                i++;
            }
            result.append(System.lineSeparator()).append(value.substring(0, value.length() - 1));
        }
        result.append(System.lineSeparator());
    }

    /**
     * Метод проверят что в параметрах находятся все необходимые данные
     */
    private static void validate(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Bot folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    public static void main(String[] args) throws Exception {
        validate(args);
        ArgsName params = ArgsName.of(args);
        CSVReader csvReader = new CSVReader(params);
        csvReader.handle();
        csvReader.display();
    }
}
