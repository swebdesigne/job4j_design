package ru.job4j.mio;

import java.io.File;
import java.text.SimpleDateFormat;

public class MakeDirectories {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private static void usage() {
        System.err.println(
            "Usage: MakeDirectories path1 ...\n"
            + "Create each path\n"
            + "Usage: MakeDirectories -d path1 ...\n"
            + "Deletes each path\n"
            + "Usage: MakeDirectories -r path1 path2\n"
            + "Renames from path1 to path2"
        );
        System.exit(1);
    }

    private static void fileData(File f) {
        System.out.println(
                String.format(
                        "Absolute path: " + f.getAbsolutePath()
                        + "\n Can read: " + f.canRead()
                        + "\n Can write: " + f.canWrite()
                        + "\n getName: " + f.getName()
                        + "\n getParent: " + f.getParent()
                        + "\n getPath: " + f.getPath()
                        + "\n length: " + f.length()
                        + "\n lastModified: " + SDF.format(f.lastModified())
                )
        );
        if (f.isFile()) {
            System.out.println("It is a file");
        } else if (f.isDirectory()) {
            System.out.println("It si directory");
        }
    }

    /**
     * -r src/main/java/ru/job4j/mio/m_test.txt src/main/java/ru/job4j/mio/m_test2.txt
     * @param args - параметры
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
        }
        if (args[0].equals("-r")) {
            if (args.length != 3) {
                usage();
            }
            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(args[count]);
            if (f.exists()) {
                System.out.println(f + " exists");
                if (del) {
                    System.out.println("deleting... " + f);
                    f.delete();
                }
            } else {
                if (!del) {
                    f.mkdir();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }
}
