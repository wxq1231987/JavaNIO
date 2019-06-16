package chapter4.datagramsocket.datagrampacketapi.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket client1 = new DatagramSocket();
        client1.connect(new InetSocketAddress("localhost", 8088));
        String newString = "我是员工";
        byte[] buf = newString.getBytes("utf-8");
        System.out.println("Length:" + buf.length);
        DatagramPacket packet = new DatagramPacket(new byte[]{}, 0);
        packet.setData(buf);
        packet.setLength(2);
        client1.send(packet);
        client1.close();
    }

}
