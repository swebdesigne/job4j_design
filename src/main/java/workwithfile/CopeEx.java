package workwithfile;

import java.io.*;

public class CopeEx {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("test2.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("test3.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write("\n");
            }
            System.out.println();
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
