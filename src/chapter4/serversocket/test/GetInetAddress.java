package chapter4.serversocket.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class GetInetAddress {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress("192.168.56.1", 8088));
        InetAddress inetAddress = server.getInetAddress();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }

}
