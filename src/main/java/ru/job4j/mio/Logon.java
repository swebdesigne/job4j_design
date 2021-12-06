package ru.job4j.mio;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {
    private final Date date = new Date();
    private final String username;
    private final transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return "Logon info: \n username: " + username
                + "\n date: " + date + "\n password:" + password;
    }

    public static void main(String[] args) {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("Logon a = " + a);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logon.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("logon.txt"))
        ) {
            out.writeObject(a);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Recovering object at " + new Date());
            a = (Logon) in.readObject();
            System.out.println("logon a = " + a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
