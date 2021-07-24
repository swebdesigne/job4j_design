package workwithfile;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFileEx {
    public static void main(String[] args) {
        try (java.io.RandomAccessFile file = new java.io.RandomAccessFile("text10.txt", "rw")) {
            file.seek(file.length() - 1);
            file.writeBytes("\n\n\t\t\t\tWilliam Butler Yeats");
            String a;
            while ((a  = file.readLine()) != null) {
                System.out.println(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
