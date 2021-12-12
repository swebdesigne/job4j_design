package ru.job4j.mio.programmer2;

import ru.job4j.mio.programmer1.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializatonEx2 {
    public static void main(String[] args) {
        Employee employee;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees2.bin"))) {
            employee = (Employee) in.readObject();
            System.out.println(employee.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
