package ru.job4j.mio;

import java.io.*;

public class FreezeAlien {
    private void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("zerialize.txt"))
        ) {
            Worm worm = new Worm();
            out.writeObject(worm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unserialize() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                new File(".", "zerialize.txt")))
        ) {
            Object obj = in.readObject().hashCode();
            System.out.println(obj.getClass());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FreezeAlien freezeAlien = new FreezeAlien();
        freezeAlien.unserialize();
    }
}
