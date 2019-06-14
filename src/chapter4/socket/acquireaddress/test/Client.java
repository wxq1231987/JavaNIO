package chapter4.socket.acquireaddress.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.bind(new InetSocketAddress("localhost", 7777));
            socket.connect(new InetSocketAddress("localhost", 8088));
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
