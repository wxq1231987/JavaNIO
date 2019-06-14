package chapter4.inetsocketaddresss.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client begin");
        Socket socket = new Socket("localhost", 8088);
        System.out.println("client end");
    }
}
