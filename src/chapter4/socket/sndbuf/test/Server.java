package chapter4.socket.sndbuf.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        InputStream ins = client.getInputStream();
        InputStreamReader reader = new InputStreamReader(ins);
        char[] cbuf = new char[1024];
        int readLength = -1;
        long beginTime = System.currentTimeMillis();
        while ((readLength = reader.read(cbuf)) != -1) {
            System.out.println(new String(cbuf, 0, readLength));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime -beginTime);
        client.close();
        server.close();
    }

}
