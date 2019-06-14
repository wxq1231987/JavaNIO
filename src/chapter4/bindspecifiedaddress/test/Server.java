package chapter4.bindspecifiedaddress.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        //server.bind(new InetSocketAddress(8088));
        //server.bind(new InetSocketAddress("localhost", 8088));
        server.bind(new InetSocketAddress(InetAddress.getByName("localhost"), 8088));
        System.out.println("server begin accept");
        Socket client = server.accept();
        System.out.println("server end accept");
    }

}
