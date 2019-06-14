package chapter4.socket.trafficclcass.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket();
            client.bind(new InetSocketAddress("localhost", 7777));
            client.setTrafficClass(0x02);
            client.connect(new InetSocketAddress("localhost", 8088));
            OutputStream ops = client.getOutputStream();
            ops.write("我是要发送的数据".getBytes());
            client.close();
            System.out.println("Client socket isClosed:" + client.isClosed());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
