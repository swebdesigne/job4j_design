package ru.job4j.mio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Класс DirFile предоставляет метод accept() для метода list(), чтобы он
 * мог вызывать accept() для определения имен файлов, включаемых в список
 */
class DirFilter implements FilenameFilter {
    private final Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    /**
     * Метод принимает в качестве аргументов объект File, представляющий
     * каталог, в котором был найден данный файл, и строку, содержащую имя файла
     * @param dir
     * @param name
     * @return
     */
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
