package workwithfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAndFilesEx1 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("C:\\Users\\beelk\\OneDrive\\Рабочий стол\\m");
        System.out.println("filePath = " + filePath.getFileName());
        System.out.println("directoryPath = " + directoryPath.getFileName());
        System.out.println("================================");
        System.out.println("filePath = " + filePath.getParent());
        System.out.println("directoryPath = " + directoryPath.getParent());
        System.out.println("================================");
        System.out.println("filePath = " + filePath.getRoot());
        System.out.println("directoryPath = " + directoryPath.getRoot());
        System.out.println("================================");
        System.out.println("filePath = " + filePath.isAbsolute());
        System.out.println("directoryPath = " + directoryPath.isAbsolute());
        System.out.println("================================");

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
    }
}
