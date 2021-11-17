package ru.job4j.mio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Echo {
    public static void main(String[] args) {
        try (
                Reader r = new InputStreamReader(System.in);
                BufferedReader bf = new BufferedReader(r)
        ) {
            String s;
            while ((s = bf.readLine()) != null && s.length() != 0) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
