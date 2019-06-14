package chapter4.serversocket.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class IsBound {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        System.out.println("bind begin " + server.isBound());
        server.bind(new InetSocketAddress("www.baidu.com不存在的网址", 8088));
        System.out.println("bind end " + server.isBound());
    }

}
