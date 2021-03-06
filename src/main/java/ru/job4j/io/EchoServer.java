package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String BYE = "Bye";
    private static final String HELLO = "Hello";
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

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
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains("msg=")) {
                            String result = echoServer.parseString(str);
                            if (BYE.equals(result)) {
                                out.write("Bye Bye!!!".getBytes());
                                server.close();
                            } else if (HELLO.equals(result)) {
                                out.write("Hello, dear friend.\n".getBytes());
                                out.write(String.format("%s%s%s", "'", result, "'").getBytes());
                            } else {
                                out.write("Hello, dear friend.\n".getBytes());
                                out.write("'What'".getBytes());
                            }
                        }
                        str = in.readLine();
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception IO ", e);
        }
    }
}
