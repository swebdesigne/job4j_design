package ru.job4j.mio;

import java.io.*;
import java.util.Scanner;
import java.util.function.Predicate;

public class Test {
    static boolean check(Predicate<String> predicate, String str) {
        return predicate.test(str);
    }

    public static void main(String[] args) throws IOException {
        PrintWriter pr = new PrintWriter("test5.txt");
        pr.println("qwe");
        System.out.println(pr);
    }
}

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

class MyExternalizable implements Externalizable {
    String name = "Igor";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
    }

    public static void main(String[] args) {
        File f = new File("dsfa");
        PrintStream err = System.err;

        try (BufferedReader bfr = new BufferedReader(new FileReader("test5.txt"))) {
            bfr.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}