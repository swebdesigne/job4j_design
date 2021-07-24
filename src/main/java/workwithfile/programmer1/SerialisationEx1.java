package workwithfile.programmer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialisationEx1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Igor");
        employees.add("Boris");
        employees.add("Alina");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees1.bin"))) {
            outputStream.writeObject(employees);
            System.out.println("done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
