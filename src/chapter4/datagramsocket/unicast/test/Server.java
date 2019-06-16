package chapter4.datagramsocket.unicast.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8088);
        byte[] buf = new byte[10];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        server.receive(packet);
        buf = packet.getData();
        System.out.println(new String(buf, 0, packet.getLength()));
        server.close();
    }

}
