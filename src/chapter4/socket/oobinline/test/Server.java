package chapter4.socket.oobinline.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8088);
            Socket client = server.accept();
            System.out.println("A OOBLINE:" + client.getOOBInline());
            //client.setOOBInline(true);
            System.out.println("B OOBLINE:" + client.getOOBInline());
            InputStream ips = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(ips);
            char[] cbuf = new char[1024];
            int readLength = -1;
            while ((readLength = reader.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, readLength));
            }
            client.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
