package chapter4.datagramsocket.transimitexceeddata.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket();
        byte[] buf = new byte[65509];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        server.receive(packet);
        server.close();
        File file = new File("D:\\getData2.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(packet.getData());
        fos.close();
    }

}
