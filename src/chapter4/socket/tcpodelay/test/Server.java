package chapter4.socket.tcpodelay.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        System.out.println("A=" + client.getTcpNoDelay());
        client.setTcpNoDelay(false);
        System.out.println("B=" + client.getTcpNoDelay());
        OutputStream ops = client.getOutputStream();
        for (int i = 0;i < 10;i++) {
            ops.write("1".getBytes());
        }
       client.close();
       server.close();
    }

}
