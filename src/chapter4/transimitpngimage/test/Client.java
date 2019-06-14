package chapter4.transimitpngimage.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String pngFile = "D:\\yangmiofcopy.jpg";
        FileInputStream fis = new FileInputStream(new File(pngFile));
        byte[] buf = new byte[1024];
        System.out.println("Socket begin " + System.currentTimeMillis());
        Socket socket = new Socket("localhost", 8088);
        System.out.println("Socket end " + System.currentTimeMillis());
        OutputStream ops = socket.getOutputStream();
        int readLength = -1;
        while ((readLength = fis.read(buf)) != -1) {
            ops.write(buf);
        }
        ops.close();
        fis.close();
        socket.close();
    }
}
