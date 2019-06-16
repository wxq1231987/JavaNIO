package chapter4.datagramsocket.transmitmostdata.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        client.connect(InetAddress.getByName("localhost"), 8088);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0;i <  65507 - 3;i++) {
            sbf.append("a");
        }
        sbf.append("end");
        DatagramPacket packet = new DatagramPacket(sbf.toString().getBytes(), sbf.length());
        client.send(packet);
        client.close();
    }
}
