package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(Set<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
                System.out.println("writing to file " + source.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validation(ArgsName check) {
        if (check.size() != 3 || (Files.notExists(Path.of(check.getPath())) || !Files.isDirectory(Path.of(check.getPath())))) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip s = new Zip();
        ArgsName params = ArgsName.of(args);
        s.validation(params);
        Search search = new Search();
        Predicate<Path> predicate = p -> !p.toFile().getName().endsWith(params.exclude());
        Set<File> paths = search.search(Paths.get(params.getPath()), predicate).stream()
                .map(Path::toFile).collect(Collectors.toSet());
        packFiles(paths, Paths.get(params.toDirection()).toFile());
    }
}
