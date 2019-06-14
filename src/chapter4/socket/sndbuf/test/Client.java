package chapter4.socket.sndbuf.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket();
        System.out.println("SNDBUF:" + client.getSendBufferSize());
        client.setSendBufferSize(1);
        System.out.println("SNDBUF:" + client.getSendBufferSize());
        client.connect(new InetSocketAddress("localhost", 8088));
        OutputStream ops = client.getOutputStream();
        for (int i = 0;i < 500;i++) {
            ops.write("123456789".getBytes());
        }
        ops.write("end!".getBytes());
        ops.close();
        System.out.println("Client is closed:" + client.isClosed());
    }
}
