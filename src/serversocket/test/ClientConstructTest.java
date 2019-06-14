package serversocket.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConstructTest {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        for (int i = 0;i < 15;i++) {
            Socket socket = new Socket(inetAddress, 8088);
            System.out.println("client发起连接次数：" + (i + 1));
        }
    }
}
