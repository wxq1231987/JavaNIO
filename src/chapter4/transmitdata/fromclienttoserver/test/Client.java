package chapter4.transmitdata.fromclienttoserver.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream ops = null;
        try {
            socket = new Socket("localhost", 8088);
            ops = socket.getOutputStream();
            ops.write("我是外星人".getBytes());
            ops.flush();
            ops.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
