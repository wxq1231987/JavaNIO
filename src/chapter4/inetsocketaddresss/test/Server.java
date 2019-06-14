package chapter4.inetsocketaddresss.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, 8088);
        server.bind(inetSocketAddress);
        System.out.println("server begin");
        Socket client = server.accept();
        System.out.println("server end");
    }

}
