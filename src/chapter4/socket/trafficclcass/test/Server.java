package chapter4.socket.trafficclcass.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8088);
            Socket client = server.accept();
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
