package chapter4.transmitdata.fromservertoclient.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        System.out.println("连接准备=" + System.currentTimeMillis());
        Socket socket = null;
        InputStreamReader reader = null;
        char[] cbuf = new char[1024];
        try {
            socket = new Socket("localhost", 8088);
            System.out.println("连接结束=" + System.currentTimeMillis());
            reader = new InputStreamReader(socket.getInputStream());
            int readLength = -1;
            while ((readLength = reader.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, readLength));
            }
            System.out.println();
            reader.close();
            socket.close();
            System.out.println("client 运行结束" + System.currentTimeMillis());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
