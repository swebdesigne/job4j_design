package io;

import java.io.*;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Set;

public class Analysis {
    private Set<Integer> statusList = Set.of(400, 500);

    public void unavailable(String source, String target) {
        boolean flag = true;
        try (FileReader read = new FileReader(source);
            BufferedReader in = new BufferedReader(read);
            PrintWriter out = new PrintWriter(new FileOutputStream(target))
        ) {
            Iterator<String> iterator = in.lines().iterator();
            while (iterator.hasNext()) {
                String[] explode = iterator.next().split(" ");
                int status = Integer.parseInt(explode[0]);
                String answ = explode[1];
                if (statusList.contains(status) && flag) {
                    out.print(answ);
                    flag = false;
                }
                if (!statusList.contains(status) && !flag) {
                    out.println(";" + answ);
                    flag = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analysis().unavailable("unavailable.csv", "target.csv");
    }
}