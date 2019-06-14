package serversocket.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBacklog {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket1 = new Socket("localhost", 8088);
        Socket socket2 = new Socket("localhost", 8088);
        Socket socket3 = new Socket("localhost", 8088);
        Socket socket4 = new Socket("localhost", 8088);
        Socket socket5 = new Socket("localhost", 8088);
    }
}
