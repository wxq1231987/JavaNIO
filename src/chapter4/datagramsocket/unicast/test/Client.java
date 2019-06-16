package chapter4.datagramsocket.unicast.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        client.connect(new InetSocketAddress("localhost", 8088));
        byte[] buf = "1234567890".getBytes();
        DatagramPacket packet = new DatagramPacket(new byte[]{}, 0);
        packet.setData(buf);
        packet.setLength(buf.length);
        client.send(packet);
        client.close();
    }
}
