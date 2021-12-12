package ru.job4j.mio.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import java.util.ArrayList;

public class SerializatonEx1  {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Igor");
        employees.add("Ivan");
        employees.add("Elena");
        try  (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees1.bin"))) {
            out.writeObject(employees);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
