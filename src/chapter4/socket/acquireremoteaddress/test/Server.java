package chapter4.socket.acquireremoteaddress.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8088);
            Socket client = server.accept();
            System.out.println("Server socket local address:" + client.getLocalAddress().getHostAddress() + ", port:"
                    + ((InetSocketAddress) client.getLocalSocketAddress()).getPort());
            System.out.println("Server socket remote address:" + client.getInetAddress().getHostAddress() + ", port:"
                    + ((InetSocketAddress) client.getRemoteSocketAddress()).getPort());
            server.close();
            client.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
