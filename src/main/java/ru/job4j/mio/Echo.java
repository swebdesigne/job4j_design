package ru.job4j.mio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) {
        try (InputStreamReader r = new InputStreamReader(System.in);
             BufferedReader bf = new BufferedReader(r)
        ) {
            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
