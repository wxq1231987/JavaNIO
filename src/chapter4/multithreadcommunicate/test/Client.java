package chapter4.multithreadcommunicate.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 8088);
        OutputStream ops = socket.getOutputStream();
        ops.write("我是中国人".getBytes());
        ops.close();
        socket.close();
    }

}
