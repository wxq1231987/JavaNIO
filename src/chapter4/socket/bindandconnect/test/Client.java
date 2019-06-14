package chapter4.socket.bindandconnect.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket client = new Socket();
            client.bind(new InetSocketAddress("localhost", 7777));
            client.connect(new InetSocketAddress("localhost", 8088));
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client end!");
    }

}
