package chapter4.datagramsocket.datagrampacketapi.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket client2 = new DatagramSocket();
        client2.connect(new InetSocketAddress("localhost", 8088));
        String newString = "我是员工";
        byte[] buf = newString.getBytes("utf-8");
        DatagramPacket packet = new DatagramPacket(new byte[]{}, 0);
        packet.setData(buf, 2, 6);
        System.out.println("Offset:" + packet.getOffset());
        client2.send(packet);
        client2.close();
    }
}
