package ru.job4j.io;

import java.util.Map;

public class SmartPhone {
    private final float battery;
    private final int storage;
    private final boolean fleshCard;
    private final Map<String, String> screen;

    public SmartPhone(float battery, int storage, boolean fleshCard, Map<String, String> screen) {
        this.battery = battery;
        this.storage = storage;
        this.fleshCard = fleshCard;
        this.screen = screen;
    }

    public float getBattery() {
        return battery;
    }

    public int getStorage() {
        return storage;
    }

    public boolean isFleshCard() {
        return fleshCard;
    }

    public Map<String, String> getScreen() {
        return screen;
    }

    @Override
    public String toString() {
        return "{"
                + "battery=" + battery
                + ", storage=" + storage
                + ", fleshCard=" + fleshCard
                + ", screen=" + screen
                + '}';
    }

}
