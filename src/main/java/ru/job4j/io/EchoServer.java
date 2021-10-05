package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String BYE = "Bye";
    private static final String HELLO = "Hello";

    private String parseString(String str) {
        String[] arr = str.split("=");
        String[] subArr = arr[1].split(" ");
        return subArr[0];
    }

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write("Hello, dear friend.".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("msg=")) {
                            String result = echoServer.parseString(str);
                            if (result.equals(BYE)) {
                                server.close();
                            } else if (result.equals(HELLO)) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write(String.valueOf("\"" + result + "\"").getBytes());
                            } else {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("\"What?\"\r\n".getBytes());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
