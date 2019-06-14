package chapter4.serversocket.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class IsClosedTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        System.out.println("IsBound:" + server.isBound());
        server.bind(new InetSocketAddress("localhost", 8088));
        System.out.println("IsBound:" + server.isBound());

        System.out.println();

        System.out.println("IsClosed:" + server.isClosed());
        server.close();
        System.out.println("IsClosed:" + server.isClosed());
    }

}
