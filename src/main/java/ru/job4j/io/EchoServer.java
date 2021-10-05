package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String BYE = "Bye";

    private boolean parseString(String str, String check) {
        String[] arr = str.split("=");
        String[] subArr = arr[1].split(" ");
        return subArr[0].equals(check);
    }

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("=")) {
                            if (echoServer.parseString(str, BYE)) {
                                server.close();
                            }
                        }
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
