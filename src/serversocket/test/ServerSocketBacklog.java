package serversocket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketBacklog {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8088, 3);
        Thread.sleep(5000);
        Socket socket1 = server.accept();
        System.out.println("socket1 end connect");
        Socket socket2 = server.accept();
        System.out.println("socket2 end connect");
        Socket socket3 = server.accept();
        System.out.println("socket3 end connect");
        Socket socket4 = server.accept();
        System.out.println("socket4 end connect");
        Socket socket5 = server.accept();
        System.out.println("socket5 end connect");
        socket1.close();
        socket2.close();
        socket3.close();
        socket4.close();
        socket5.close();
    }
}
