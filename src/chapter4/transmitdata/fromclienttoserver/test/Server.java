package chapter4.transmitdata.fromclienttoserver.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        char[] cbuf = new char[4];
        ServerSocket server = null;
        Socket socket = null;
        InputStream inputStream = null;
        InputStreamReader reader = null;
        try {
            server = new ServerSocket(8088);
            System.out.println("accept begin");
            socket = server.accept();
            System.out.println("accept end");
            inputStream = socket.getInputStream();
            reader = new InputStreamReader(inputStream);
            int readLength = -1;
            while ((readLength = reader.read(cbuf)) != -1) {
                String newString = new String(cbuf, 0, readLength);
                System.out.println(newString);
            }
            reader.close();
            inputStream.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
