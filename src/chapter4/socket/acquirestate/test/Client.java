package chapter4.socket.acquirestate.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket client = null;
        try {
            client = new Socket();
            System.out.println("IsBound:" + client.isBound());
            client.bind(new InetSocketAddress("localhost", 7777));
            System.out.println("IsBound:" + client.isBound());

            System.out.println("IsConnected:" + client.isConnected());
            client.connect(new InetSocketAddress("localhost", 8888));
            System.out.println("IsConnected:" + client.isConnected());

            System.out.println("IsClosed:" + client.isClosed());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
                System.out.println("IsClosed:" + client.isClosed());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
