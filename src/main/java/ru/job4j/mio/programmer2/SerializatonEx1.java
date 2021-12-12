package ru.job4j.mio.programmer2;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerializatonEx1  {
    public static void main(String[] args) {
        List<String> employees;
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employees1.bin"))
        ) {
            employees = (ArrayList) in.readObject();
            System.out.println(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
