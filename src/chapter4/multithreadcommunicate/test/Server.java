package chapter4.multithreadcommunicate.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        int runTag = 1;
        while (runTag == 1) {
            Socket socket = server.accept();
            ReqHandler handler = new ReqHandler(socket);
            handler.start();
        }
        server.close();
    }
}
