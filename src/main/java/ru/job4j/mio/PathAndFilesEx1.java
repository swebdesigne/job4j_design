package ru.job4j.mio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAndFilesEx1 {    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("./test15.txt");
        Path directoryPath = Paths.get("mdirectory");
        filePath.getFileName();
        System.out.println("filePath.getFileName() " + filePath.getFileName());
        System.out.println("directoryPath.getFileName() " + directoryPath.getFileName());
        System.out.println(System.lineSeparator());
        System.out.println("filePath.getParent() " + filePath.toAbsolutePath());
        System.out.println("directoryPath.getParent() " + directoryPath.toAbsolutePath());
    }
}
