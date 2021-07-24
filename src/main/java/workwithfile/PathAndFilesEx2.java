package workwithfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("C:\\Users\\beelk\\OneDrive\\Рабочий стол\\m");
        Path directoryBPath = Paths.get("C:\\Users\\beelk\\OneDrive\\Рабочий стол\\b");

        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(filePath, directoryPath.resolve("test16.txt"), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(directoryBPath, directoryPath.resolve("B"));
        System.out.println("done");

        Files.move(filePath, directoryPath.resolve("test20.txt"));
        Files.move(Paths.get("test3.txt"), (Paths.get("replace_test3.txt")));
        Files.delete(Paths.get("replace_test3.txt"));

    }
}
