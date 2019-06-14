package chapter4.socket.bindandconnect.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        server.close();
        System.out.println("server end!");
    }

}
