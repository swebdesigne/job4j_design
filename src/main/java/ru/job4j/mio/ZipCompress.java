package ru.job4j.mio;

import java.io.*;
import java.util.zip.*;

/**
 * Класс ZipCompress используется для
 * сжатия любого количества файлов, указанных в командной строке
 */
public class ZipCompress {
    private String[] args;

    /**
     * метод архивирует файлы
     * в аргументы необходимо передать наименование файла который будет зиповаться
     */
    private void compress() {
        try (FileOutputStream f = new FileOutputStream("compress.zip");
             CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
             ZipOutputStream zos = new ZipOutputStream(csum);
             BufferedOutputStream out = new BufferedOutputStream(zos)
        ) {
            zos.setComment("A test of java Zipping");
            for (String arg : this.args) {
                System.out.println(arg);
                System.out.println("Writing file " + arg);
                BufferedReader in = new BufferedReader(new FileReader(arg));
                zos.putNextEntry(new ZipEntry(arg));
                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
                out.flush();
            }
            System.out.println("Checksum: " + csum.getChecksum().getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод читает из архива определенный файл
     * в аргументы необходимо передать наименование файла который будет
     * читаться.
     * У нас имеется zip файл compress.zip в нем имеется файл test10.txt
     * значит в аргументы мы передаем test10.txt
     */
    private void uncompress() {
        System.out.println("Reading the file");
        try (FileInputStream fi = new FileInputStream("compress.zip");
             CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
             ZipInputStream in = new ZipInputStream(csumi);
             BufferedInputStream bf = new BufferedInputStream(in)
        ) {
            ZipEntry ze;
            while ((ze = in.getNextEntry()) != null) {
                System.out.println("Reading the file " + ze);
                int x;
                while ((x = bf.read()) != -1) {
                    System.out.write(x);
                }
            }
            if (this.args.length == 1) {
                System.out.println("Checksum: " + csumi.getChecksum().getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZipCompress zip = new ZipCompress();
        zip.args = args;
    }
}