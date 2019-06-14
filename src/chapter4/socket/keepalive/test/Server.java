package chapter4.socket.keepalive.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("server begin");
            Socket client = server.accept();
            System.out.println("server end");
            Thread.sleep(Integer.MAX_VALUE);
            client.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
