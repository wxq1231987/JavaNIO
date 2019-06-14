package chapter4.threehandshake.test;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException {
        ServerSocket server = new ServerSocket(8088);
        System.out.println("server阻塞开始" + System.currentTimeMillis());
        server.accept();
        System.out.println("server阻塞结束" + System.currentTimeMillis());
        Thread.sleep(Integer.MAX_VALUE);
        server.close();
    }
}
