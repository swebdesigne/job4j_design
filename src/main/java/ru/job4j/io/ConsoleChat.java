package ru.job4j.io;
import ru.job4j.io.smartbot.*;

import java.io.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.System.*;

/**
 * Класс описывает работу программы 'Консольный чат'
 * @author IGOR SIVOLOBOV
 * @version 1.0
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private String console = "";
    private static final String STOP = "стоп";
    private static final String OUT = "закончить";
    private static final String MAN = "инструкция";
    private static final String CONTINUE = "продолжить";

    /**
     *
     * @param path - путь
     * @param botAnswers - ответ бота
     */
    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    /**
     * Метод читает данные с консоли, берет рандомно ответ с файла botAnswers.txt
     * и записывает историю в файл log.txt
     * @throws IOException
     */
    public void run() {
        out.println("Чтобы просмотреть допустимые команды необходимо написать `инструкция`");
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String output = bufferedReader.readLine();
            if (output.equals(STOP) || output.equals(OUT) || output.equals(MAN) || output.equals(CONTINUE)) {
                console = output;
            }
            bot(console).execute(this, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param execute - параметр для мапы
     * @return - возвращаем объект (ответ) от нашего бота
     */
    private SmartBot bot(String execute) {
     return Map.of(
        OUT, new SmartBot(new Out()),
        STOP, new SmartBot(new Stop()),
        MAN, new SmartBot(new Manual()),
        CONTINUE, new SmartBot(new Default())
        ).getOrDefault(execute, new SmartBot(new Default()));
    }

    /**
     * метод читает из файла botAnswers.txt и формирует список ответов
     * @return - возвращет рандомно ответ
     */
    public String readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            answers = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers.get((int) (Math.random() * answers.size() - 1));
    }

    /**
     * метод пишет историю в log.txt
     * @param log - история переписки
     */
    public void saveLog(List<String> log) {
         try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
             log.forEach(pw::println);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    /**
     * Метод проверят что в параметрах указаны пути до файлов
     * @param log - файл для записи логов
     * @param botAnswers - файл с ответами бота
     */
    private static void validate(String[] args, String log, String botAnswers) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Bot folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        String paramForLog = args[0].split("=")[0];
        String paramForBotAnswer = args[1].split("=")[0];
        if (!paramForLog.equals("-l")) {
            throw new IllegalArgumentException("Attention! The parameter of the file of log have to be `-l`. Please to point such argument into parameters!");
        }
        if (!paramForBotAnswer.equals("-a")) {
            throw new IllegalArgumentException("Attention! The parameter of the file of botAnswers have to be `-a`. Please to point such argument into parameters!");
        }
        if (!Files.exists(Paths.get(botAnswers))) {
            throw new IllegalArgumentException("BotAnswers file not exists.");
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName params = ArgsName.of(args);
        String log =  params.get("-l");
        String botAnswers = params.get("-a");
        validate(args, log, botAnswers);
        ConsoleChat cc = new ConsoleChat(log, botAnswers);
        out.println("Привет хозяин!!!");
        cc.run();
    }
}