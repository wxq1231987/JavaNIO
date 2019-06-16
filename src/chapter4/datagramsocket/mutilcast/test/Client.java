package chapter4.datagramsocket.mutilcast.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {

    public static void main(String[] args) throws IOException {
        MulticastSocket client = new MulticastSocket();
        byte[] buf = "1234567890".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length,
                InetAddress.getByName("224.0.0.5"), 8088);
        client.send(packet);
        client.close();
    }
}
