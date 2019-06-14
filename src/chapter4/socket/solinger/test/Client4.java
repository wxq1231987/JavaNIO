package chapter4.socket.solinger.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client4 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8088);
        InputStream ips = socket.getInputStream();
        byte[] array = new byte[1];
        int readLength = -1;
        while ((readLength = ips.read(array)) != -1) {
            System.out.println(new String(array, 0, readLength));
        }
        System.out.println("E:" + System.currentTimeMillis());
        ips.close();
        socket.close();
    }

}
