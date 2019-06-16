package chapter4.datagramsocket.transimitexceeddata.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        client.connect(new InetSocketAddress("localhost", 8088));
        StringBuffer sbf = new StringBuffer();
        for (int i = 0;i < 65507 - 3;i++) {
            sbf.append("a");
        }
        sbf.append("end");
        sbf.append("zz");
        DatagramPacket packet = new DatagramPacket(sbf.toString().getBytes(), sbf.length());
        client.send(packet);
        client.close();
    }

}
