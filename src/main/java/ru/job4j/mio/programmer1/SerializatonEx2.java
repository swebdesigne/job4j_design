package ru.job4j.mio.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializatonEx2 {
    public static void main(String[] args) {
        Employee employee = new Employee(
                "Igor", "IT", 34, 38, new Car("Mada", "black")
        );
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees2.bin"))) {
            out.writeObject(employee);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
