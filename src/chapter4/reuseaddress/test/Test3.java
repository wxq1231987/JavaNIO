package chapter4.reuseaddress.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test3 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket( );
        System.out.println("accept begin");
        Socket client = server.accept();
        System.out.println("accept end");
        client.close();
        server.close();
    }

}
