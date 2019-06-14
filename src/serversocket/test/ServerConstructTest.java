package serversocket.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConstructTest {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8088, 3, InetAddress.getLocalHost());
        Thread.sleep(5000);
        for (int i = 0;i < 5;i++) {
            System.out.println("accept begin " + i);
            Socket socket = server.accept();
            System.out.println("accept end " + i);
        }
        server.close();
    }

}
