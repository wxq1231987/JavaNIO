package chapter4.socket.solinger.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setReceiveBufferSize(1);
        socket.bind(new InetSocketAddress("localhost", 7777));
        socket.connect(new InetSocketAddress("localhost", 8088));
        InputStream ips = socket.getInputStream();
        byte[] arr = new byte[1];
        int readLength = -1;
        while((readLength = ips.read(arr)) != -1) {
            System.out.println(new String(arr, 0, readLength));
        }
        System.out.println("client read end time=" + System.currentTimeMillis());
        ips.close();
        socket.close();
    }

}
