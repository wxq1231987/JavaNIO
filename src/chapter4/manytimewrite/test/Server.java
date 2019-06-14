package chapter4.manytimewrite.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /**
     * 测试允许多次调用write方法进行写入操作
     * @param args
     */
    public static void main(String[] args) {
        char[] cbuf = new char[1024];
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8088);
            System.out.println("Server begin block=" + System.currentTimeMillis());
            socket = server.accept();
            System.out.println("Server end block=" + System.currentTimeMillis());

            InputStream inputStream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            System.out.println("Server begin read " + System.currentTimeMillis());
            int readLength = -1;
            while ((readLength = reader.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, readLength));
            }
            System.out.println("Server end read " + System.currentTimeMillis());
            inputStream.close();
            reader.close();
            socket.close();
            server.close();
            System.out.println("server run end " + System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
