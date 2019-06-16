package chapter4.datagramsocket.trasmitdata.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.connect(InetAddress.getByName("localhost"), 8088);
        String newString = "123456789012";
        byte[] array = newString.getBytes();
        DatagramPacket packet = new DatagramPacket(array, array.length);
        socket.send(packet);
        socket.close();
    }

}
