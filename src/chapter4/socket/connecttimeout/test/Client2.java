package chapter4.socket.connecttimeout.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) {
        long beginTime = 0;
        try {
            Socket socket = new Socket();
            beginTime = System.currentTimeMillis();
            socket.connect(new InetSocketAddress("1.1.1.1", 80), 6000);
            socket.close();
            System.out.println("client end!");
        } catch (IOException e) {
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - beginTime);
            e.printStackTrace();
        }
    }

}
