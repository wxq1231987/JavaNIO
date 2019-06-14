package chapter4.socket.bindandconnect.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        client.close();
        server.close();
        System.out.println("server end!");
    }

}
