package ru.job4j.mio;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Класс получает содержимое каталогов
 * @author IGOR SIVOLOBOV
 * @version 1.0
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
