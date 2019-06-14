package chapter4.socket.acquireport.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            socket = server.accept();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("服务器输出：");
        System.out.println("Server socket local Port:" + socket.getLocalPort());
        System.out.println("Server socket remote port:" + socket.getPort());
    }

}
