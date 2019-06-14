package chapter4.socket.halfwrite.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 8088);
        InputStream ins = socket.getInputStream();
        byte[] arr = new byte[100];
        int readLength = ins.read(arr);
        while ((readLength = ins.read(arr)) != -1) {
            System.out.println(new String(arr, 0, readLength));
        }
        ins.close();
        socket.close();
    }
}
