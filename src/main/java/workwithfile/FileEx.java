package workwithfile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("test2.txt");
        File folder =  new File("C:\\Users\\beelk\\OneDrive\\Рабочий стол");
        System.out.println(file.getAbsoluteFile());
        System.out.println(folder.getAbsoluteFile());
        System.out.println();
        System.out.println(folder.isAbsolute());
        System.out.println();
        System.out.println(file.isDirectory());
        System.out.println();
        System.out.println(file.isDirectory());
        file.exists();
        System.out.println();
        file.createNewFile();
        folder.mkdir();
        System.out.println();
        file.delete();
        System.out.println();
        File[] files = folder.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println(file.isHidden());
        System.out.println();
        System.out.println(file.canExecute());
    }
}
