package chapter4.setreceivebuffersize.test;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        System.out.println("A server serverSocket.getReceiveBufferSize()="
                + server.getReceiveBufferSize());
        server.setReceiveBufferSize(66);
        System.out.println("A serer serverSocket.getReceiveBufferSize()="
                + server.getReceiveBufferSize());
    }
}
