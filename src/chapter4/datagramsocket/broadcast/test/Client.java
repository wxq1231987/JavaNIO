package chapter4.datagramsocket.broadcast.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        /**
         * 使用广播地址
         */
        client.connect(new InetSocketAddress("192.168.8.255", 8088));
        String newString = "1234567890";
        byte[] buf = newString.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        client.send(packet);
        client.close();
    }

}
