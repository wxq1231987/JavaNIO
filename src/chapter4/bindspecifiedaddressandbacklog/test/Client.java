package chapter4.bindspecifiedaddressandbacklog.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        for (int i = 0;i < 100;i++) {
            System.out.println("client begin " + (i + 1));
            Socket client = new Socket(InetAddress.getByName("localhost"), 8088);
            System.out.println("client end " + (i + 1));
        }
    }

}
