package io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IO {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8090);
        ss.setSoTimeout(100);

        Socket socket = ss.accept();

        ss.close();
    }
}
