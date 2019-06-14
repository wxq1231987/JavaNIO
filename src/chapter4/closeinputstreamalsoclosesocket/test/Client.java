package chapter4.closeinputstreamalsoclosesocket.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8088);
        OutputStream ops = socket.getOutputStream();
        ops.write("我在做小测试".getBytes());
        ops.close();
        Thread.sleep(Integer.MAX_VALUE);
    }

}
