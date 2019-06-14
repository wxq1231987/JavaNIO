package chapter4.socket.keepalive.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Client begin");
            Socket client = new Socket("localhost", 8888);
            System.out.println("Client end");
            Thread.sleep(Integer.MAX_VALUE);
            client.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
