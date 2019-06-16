package chapter4.datagramsocket.trasmitdata.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8088);
        byte[] buf = new byte[12];
        DatagramPacket packet = new DatagramPacket(buf, 10);
        server.receive(packet);
        server.close();
        System.out.println("Length:" + packet.getLength());
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
    }

}
