package chapter4.socket.acquireport.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("localhost", 8888);
        System.out.println("客户端输出：");
        System.out.println("Client local port:" + client.getLocalPort());
        System.out.println("Client remote port:" + client.getPort());
        client.close();
    }

}
