package workwithfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesEx3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test11.txt");
        Files.createFile(filePath);
        String dialog = "- Privet\n- Kak dela?\n";
        Files.write(filePath, dialog.getBytes());
        List<String> files = Files.readAllLines(filePath);
        for (String s : files) {
            System.out.println(s);
        }
    }
}
