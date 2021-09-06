package io;

import java.io.*;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Set;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean flag = false;
        Set<Integer> errStatus = Set.of(400, 500);
        try (FileReader read = new FileReader(source);
            BufferedReader in = new BufferedReader(read);
            PrintWriter out = new PrintWriter(new FileOutputStream(target))
        ) {
            Iterator<String> iterator = in.lines().iterator();
            while (iterator.hasNext()) {
                String msg = iterator.next();
                int status = Integer.parseInt(msg.split(" ")[0]);
                if (errStatus.contains(status) && !flag) {
                    out.print(msg.substring(4));
                    flag = true;
                }
                if (!errStatus.contains(status) && flag) {
                    out.println(";" + msg.substring(4));
                    flag = false;
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