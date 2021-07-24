package workwithfile.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialisation2 {
    public static void main(String[] args) {
        Car car = new Car("BMW", "black");
        Employee employee = new Employee("Igor", "IT", 20, 500, car);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employee2.bin"))) {
            outputStream.writeObject(employee);
            System.out.println("done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
