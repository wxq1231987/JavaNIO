package chapter4.socket.acquireaddress.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8088);
            client = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress inetAddress = client.getLocalAddress();
        InetSocketAddress socketAddress = (InetSocketAddress) client.getLocalSocketAddress();
        System.out.println("InetAddress ip:" + inetAddress.getHostAddress() + ", host:"
                + inetAddress.getHostName());
        System.out.println("SocketAddress ip:" + socketAddress.getHostString() + ", host:"
                + socketAddress.getHostName() + "port:" + socketAddress.getPort());

        try {
            client.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
