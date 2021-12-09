package ru.job4j.mio;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    private void fileWriter(String str) {
        try (FileWriter fileWriter = new FileWriter("w_rubai.txt", true)) {
            String hi = "Hello";
            fileWriter.write(hi);
            for (int i = 0; i < str.length(); i++) {
                fileWriter.write(str.charAt(i));
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileWriterEx ex = new FileWriterEx();
        String rubai = "Не делай зла — вернется бумерангом,\n"
                + "Не плюй в колодец — будешь воду пить,\n"
                + "Не оскорбляй того, кто ниже рангом,\n"
                + "А вдруг придется, что-нибудь просить.\n"
                + "Не предавай друзей, их не заменишь,\n"
                + "И не теряй любимых — не вернешь,\n"
                + "Не лги себе — со временем проверишь,\n"
                + "Что этой ложью сам себя ты предаёшь.";
        ex.fileWriter(rubai);
        ex.fileWriter("Bye bye!!!");
    }
}
