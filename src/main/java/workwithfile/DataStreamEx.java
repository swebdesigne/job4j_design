package workwithfile;

import java.io.*;

public class DataStreamEx {
    public static void main(String[] args) {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("myTest.bin"));
            DataInputStream inputStream = new DataInputStream(new FileInputStream("myTest.bin"))
        ) {
            outputStream.writeBoolean(true);
            outputStream.writeByte(5);
            outputStream.writeShort(120);
            outputStream.writeDouble(12.5);

            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
