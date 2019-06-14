package chapter4.socket.acquirestate.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8888);
            client = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                client.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
