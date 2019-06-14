package chapter4.bindspecifiedaddressandbacklog.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(InetAddress.getByName("localhost"), 8088), 50);
        Thread.sleep(8000);
        for (int i = 0;i < 100;i++) {
            System.out.println("server accept begin " + (i + 1));
            Socket client = server.accept();
            System.out.println("server accept end " + (i + 1));
            client.close();
        }
        server.close();
    }

}
