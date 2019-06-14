package serversocket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SetSoTimeoutTest {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        System.out.println(server.getSoTimeout());
        server.setSoTimeout(4000);
        System.out.println("Accept begin " + System.currentTimeMillis());
        Socket socket = server.accept();
        System.out.println("Accept end " + System.currentTimeMillis());
    }
}