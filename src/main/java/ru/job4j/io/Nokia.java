package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class Nokia {
    private final String name;
    private final SmartPhone hardware;
    private final int year;
    private float price;
    private String[] colors;

    public Nokia(String name, int year, float price, SmartPhone hardware, String... color) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.hardware = hardware;
        this.colors = color;
    }

    @Override
    public String toString() {
        return "Nokia{"
                + "name='" + name
                + ", hardware=" + hardware
                + ", year=" + year
                + ", price=" + price
                + ", colors=" + Arrays.toString(colors)
                + '}';
    }

    public static void main(String[] args) throws IOException {
        Nokia phone = new Nokia(
                "Nokia 2100", 2021, 40.21F,
                new SmartPhone(3.400F, 128, true, Map.of("type", "IPS", "resolution", "2400x1080", "Hz", "120")),
                "red", "black"
        );
        final Gson gson = new GsonBuilder().create();
        String data = gson.toJson(phone);
        System.out.println(data);

        final Nokia dataFromJson = gson.fromJson(data, Nokia.class);
        System.out.println(dataFromJson);
    }
}
