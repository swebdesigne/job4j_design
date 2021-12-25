package ru.job4j.mio;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Whois {
    public static void main(String[] args) throws IOException {
        ServerSocket srs = new ServerSocket(80);
        int c;
        URL url = new URL("https://mirabilien.ru");
        HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();

        System.out.println(urlCon.getHeaderFields());
        args = new String[] {"https://mirabilien.ru/"};
        StringBuilder stb = new StringBuilder();
        try (Socket s = new Socket("whois.internic.net", 43)) {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String str = "mirabilien.ru\n";
            byte[] buf = str.getBytes(StandardCharsets.UTF_8);
            out.write(buf);
            while ((c = in.read()) != -1) {
                stb.append((char) c);
            }
            System.out.println(stb);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
