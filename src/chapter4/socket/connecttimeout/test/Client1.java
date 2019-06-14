package chapter4.socket.connecttimeout.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) {
        long beginTime = 0;
        Socket socket = new Socket();
        try {
            socket.bind(new InetSocketAddress("192.168.56.1", 7777));//192.168.56.1,192.168.8.101
            beginTime = System.currentTimeMillis();
            socket.connect(new InetSocketAddress("1.1.1.1", 8888), 6000);
            socket.close();
            System.out.println("client end!");
        } catch (IOException e) {
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - beginTime);
            e.printStackTrace();
        }
    }

}
