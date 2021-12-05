package ru.job4j.mio;

import java.io.*;
import java.util.Random;

public class Worm implements Serializable {
    private static Random random = new Random(47);
    private Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    public Worm() {
        System.out.println("Default constructor");
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append("(");
        for (Data dat : d) {
            result.append(dat);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test20.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("test20.txt"));
             ByteArrayOutputStream bout = new ByteArrayOutputStream();
             ObjectOutputStream out2 = new ObjectOutputStream(bout);
             ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(
                     bout.toByteArray()
             ))
        ) {
            Worm w = new Worm(6, 'a');
            System.out.println("w = " + w);
            out.writeObject("Worm storage\n");
            out.writeObject(w);
            String s = (String) in.readObject();
            Worm w2 = (Worm) in.readObject();
            System.out.println(s + "w2 = " + w2);
            out2.writeObject("Worm storage\n");
            out2.writeObject(w);
            out2.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
