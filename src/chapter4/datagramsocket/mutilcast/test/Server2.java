package chapter4.datagramsocket.mutilcast.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/**
 * 组播
 * @author Wang XuQin
 *
 */
public class Server2 {

    public static void main(String[] args) throws IOException {
        MulticastSocket server = new MulticastSocket(8088);
        server.joinGroup(InetAddress.getByName("224.0.0.5"));
        byte[] buf = new byte[10];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        server.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        server.close();
    }

}
