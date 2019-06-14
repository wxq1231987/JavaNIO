package chapter4.closeinputstreamalsoclosesocket.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        byte[] charArr = new byte[10];
        ServerSocket server = new ServerSocket(8088);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        int readLength = -1;
        while ((readLength = inputStream.read(charArr)) != -1) {
            System.out.println(new String(charArr, 0, readLength));
        }
        inputStream.close();
        OutputStream ops = socket.getOutputStream();
        socket.close();
        server.close();
    }

}
