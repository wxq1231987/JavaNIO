package chapter4.transmitdata.fromservertoclient.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        System.out.println("Server阻塞开始：" + System.currentTimeMillis());
        Socket socket = server.accept();
        System.out.println("Server阻塞结束：" + System.currentTimeMillis());

        OutputStream ops = socket.getOutputStream();
        ops.write("我是地球人".getBytes());
        System.out.println("Server已断开");
        ops.close();
        socket.close();
        server.close();
    }

}
