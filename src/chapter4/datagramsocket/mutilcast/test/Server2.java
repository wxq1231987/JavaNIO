package chapter4.datagramsocket.mutilcast.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server2 {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8088);
        byte[] buf = new byte[10];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        server.receive(packet);
        server.close();
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
    }

}
