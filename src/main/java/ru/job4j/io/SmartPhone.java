package ru.job4j.io;

import javax.xml.bind.annotation.*;
import java.util.Map;

@XmlRootElement(name = "SmartPhone")
public class SmartPhone {
    @XmlAttribute
    private float battery;
    @XmlAttribute
    private int storage;
    @XmlAttribute
    private boolean fleshCard;
    @XmlElement
    private Map<String, String> screen;

    public SmartPhone() {
    }

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
