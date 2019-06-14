package chapter4.socket.halfwrite.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8088);
            client = server.accept();
            OutputStream ops = client.getOutputStream();
            ops.write("abcdef".getBytes());
            client.shutdownOutput();
            //client.getOutputStream();
            ops.write("123".getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("IsOutputShutdown:" + client.isOutputShutdown());
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
