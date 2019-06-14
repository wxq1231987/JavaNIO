package chapter4.getlocaladdrinfo.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        System.out.println("new ServerSocket()无参构造的端口是：" + server.getLocalPort());
        server.bind(new InetSocketAddress("192.168.56.1", 8888));
        System.out.println("bind(SocketAddress)的端口是:" + server.getLocalPort());

        InetSocketAddress inetSocketAddress = (InetSocketAddress) server.getLocalSocketAddress();
        System.out.println("InetSocketAddress.getHostName=" + inetSocketAddress.getHostName());
        System.out.println("InetSocketAddress.getHostString=" + inetSocketAddress.getHostString());
        System.out.println("InetSocketAddress.getPort=" + inetSocketAddress.getPort());

        server.close();
    }

}
