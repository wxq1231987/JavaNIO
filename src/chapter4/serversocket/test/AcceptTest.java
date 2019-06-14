package chapter4.serversocket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptTest {
    /**
     * 验证accept方法具有阻塞性
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        System.out.println("server begin block");
        Socket client = server.accept();
        System.out.println("server end block");
        client.close();
    }

}
