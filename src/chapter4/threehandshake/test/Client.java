package chapter4.threehandshake.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        System.out.println("client连接服务=" + System.currentTimeMillis());
        Socket socket = new Socket("localhost", 8088);
        System.out.println("client连接结束=" + System.currentTimeMillis());
        OutputStream ops = socket.getOutputStream();
        ops.write("111".getBytes());
        ops.write("1111".getBytes());
        ops.write("11111".getBytes());
        Thread.sleep(50000000);
        socket.close();
    }

}
