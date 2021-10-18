package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.Arrays;
import java.util.Map;

@XmlRootElement(name = "nokia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Nokia {
    private String name;
    private SmartPhone hardware;
    private int year;
    private float price;
    @XmlElementWrapper(name = "colors")
    @XmlElement(name = "color")
    private String[] colors;

    public Nokia() {
    }

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

    public static void main(String[] args) throws IOException, JAXBException {
        final Nokia phone = new Nokia(
                "Nokia 2100", 2021, 40.21F,
                new SmartPhone(3.400F, 128, true, Map.of("type", "IPS", "resolution", "2400x1080", "Hz", "120")),
                "red", "black"
        );

        System.out.println(new JSONObject(phone));

        final Gson gson = new GsonBuilder().create();
        String data = gson.toJson(phone);
        System.out.println(data);

        final Nokia dataFromJson = gson.fromJson(data, Nokia.class);
        System.out.println(dataFromJson);

        JAXBContext context = JAXBContext.newInstance(Nokia.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(phone, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Cannot serialize");
        }
    }
}
