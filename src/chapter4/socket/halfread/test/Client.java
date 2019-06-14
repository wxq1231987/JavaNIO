package chapter4.socket.halfread.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8088);
        OutputStream ops = client.getOutputStream();
        ops.write("abcdef".getBytes());
        client.close();
    }

}
