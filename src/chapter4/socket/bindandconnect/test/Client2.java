package chapter4.socket.bindandconnect.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket();
        System.out.println("A Port:" + client.getLocalPort());
        try {
            client.connect(new InetSocketAddress("localhost", 8888));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("B Port:" + client.getLocalPort());
        client.close();
        System.out.println("client end!");
    }

}
