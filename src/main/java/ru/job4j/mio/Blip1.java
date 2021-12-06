package ru.job4j.mio;

import java.io.*;

public class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
     public Blip2() {
        System.out.println("Blip constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blips {
    private void serialize(Blip1 b1, Blip2 b2) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("blips.txt"))) {
            System.out.println("saving objects");
            out.writeObject(b1);
            out.writeObject(b2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unserialize(Blip1 b1, Blip2 b2) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("blips.txt"))) {
            System.out.println("recovering b1: ");
            b1 = (Blip1) in.readObject();
            b2 = (Blip2) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Constructing objects: ");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        Blips b = new Blips();
        b.serialize(b1, b2);
        b.unserialize(b1, b2);

    }
}