package chapter4.socket.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class acceptServerTest {
    /**
     * 验证accept方法具有阻塞性
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client begin connect server");
        Socket client = new Socket("localhost", 8088);
        System.out.println("Client end connect server");
        client.close();
    }
}
