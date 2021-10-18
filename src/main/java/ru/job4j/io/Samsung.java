package ru.job4j.io;

import org.json.JSONObject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.Arrays;
import java.util.Map;

@XmlRootElement(name = "samsung")
@XmlAccessorType(XmlAccessType.FIELD)
public class Samsung {
    private String name;
    private SmartPhone hardware;
    private int year;
    private float price;
    @XmlElementWrapper(name = "colors")
    @XmlElement(name = "color")
    private String[] colors;

    public Samsung() {
    }

    public Samsung(String name, int year, float price, SmartPhone hardware, String... color) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.hardware = hardware;
        this.colors = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SmartPhone getHardware() {
        return hardware;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
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

    public static void main(String[] args) throws IOException, JAXBException {
        SmartPhone property = new SmartPhone(3.400F, 128, true, Map.of("type", "IPS", "resolution", "2400x1080", "Hz", "120"));
        Samsung phone = new Samsung(
                "Samsung 2100", 2021, 40.21F, property,
                "red", "black"
        );
        property.setPhone(phone);
        System.out.println(new JSONObject(phone));
    }
}