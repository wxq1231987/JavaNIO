package chapter4.manytimewrite.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        System.out.println("client begin connect " + System.currentTimeMillis());
        Socket socket = new Socket("localhost", 8088);
        System.out.println("client end connect " + System.currentTimeMillis());
        OutputStream writer = socket.getOutputStream();
        System.out.println("client begin write " + System.currentTimeMillis());
        writer.write("第一次写".getBytes());
        Thread.sleep(2000);
        writer.write("第二次写".getBytes());
        Thread.sleep(3000);
        writer.write("第三次写".getBytes());
        Thread.sleep(3000);
        writer.write("第四次写".getBytes());
        System.out.println("client end write " + System.currentTimeMillis());
        writer.close();
        socket.close();
    }

}
