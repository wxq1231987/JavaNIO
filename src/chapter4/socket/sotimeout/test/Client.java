package chapter4.socket.sotimeout.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        Socket client = new Socket("localhost", 8088);
        Thread.sleep(Integer.MAX_VALUE);
    }

}
