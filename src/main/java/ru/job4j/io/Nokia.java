package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Map;

public class Nokia {
    private final String name;
    private final SmartPhone hardware;
    private final int year;
    private float price;

    public Nokia(String name, int year, float price, SmartPhone hardware) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.hardware = hardware;
    }

    @Override
    public String toString() {
        return "Nokia{"
                + "name='" + name
                + ", year=" + year
                + ", price=" + price
                + ", hardware=" + hardware
                + '}';
    }

    public static void main(String[] args) throws IOException {
        Nokia phone = new Nokia("Nokia 2100", 2021, 40.21F,
                new SmartPhone(3.400F, 128, true, Map.of("type", "IPS", "resolution", "2400x1080", "Hz", "120"))
        );
        final Gson gson = new GsonBuilder().create();
        String data = gson.toJson(phone);
        System.out.println(data);

        final Nokia dataFromJson = gson.fromJson(data, Nokia.class);
        System.out.println(dataFromJson);
    }
}
