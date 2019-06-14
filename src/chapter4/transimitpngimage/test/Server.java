package chapter4.transimitpngimage.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[1024];
        ServerSocket server = new ServerSocket(8088);
        Socket socket = server.accept();
        InputStream ips = socket.getInputStream();
        int readLength = -1;
        FileOutputStream fos = new FileOutputStream(new File("D:\\yangmi.jpg"));
        while ((readLength = ips.read(buf)) != -1) {
            fos.write(buf, 0, readLength);
        }
        fos.close();
        ips.close();
        socket.close();
        server.close();
    }

}
