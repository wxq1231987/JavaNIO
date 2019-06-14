package chapter4.socket.acquireremoteaddress.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            System.out.println("Client local address:" + socket.getLocalAddress().getHostAddress() + ", port:"
                    + ((InetSocketAddress) socket.getLocalSocketAddress()).getPort());
            System.out.println("Client remote address:" + socket.getInetAddress().getHostAddress() + ", port:"
                    + ((InetSocketAddress) socket.getRemoteSocketAddress()).getPort());
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
