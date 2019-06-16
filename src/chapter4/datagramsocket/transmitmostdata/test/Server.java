package chapter4.datagramsocket.transmitmostdata.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8088);
        byte[] buf = new byte[65507];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        server.receive(packet);
        File file = new File("D:\\getData.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(packet.getData());
        fos.flush();
    }

}
