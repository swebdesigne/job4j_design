package ru.job4j.mio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("mdirectory");
        if (!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath);
        }
        Files.move(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
    }
}
