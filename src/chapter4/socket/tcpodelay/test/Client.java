package chapter4.socket.tcpodelay.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("localhost", 8088);
        client.setTcpNoDelay(false);
        InputStream ins = client.getInputStream();
        long beginTime = System.currentTimeMillis();
        byte[] arr = new byte[1];
        int readLength = -1;
        while ((readLength = ins.read(arr)) != -1) {
            System.out.println(new String(arr, 0, readLength));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        client.close();
    }

}
