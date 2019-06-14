package chapter4.bindspecifiedaddress.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client request begin");
        Socket client = new Socket("localhost", 8088);
        System.out.println("client request end");
    }

}
