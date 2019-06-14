package chapter4.socket.sotimeout.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        System.out.println("SoTimeout:" + client.getSoTimeout());
        client.setSoTimeout(5000);
        System.out.println("SoTimeout:" + client.getSoTimeout());
        InputStream ips = client.getInputStream();
        byte[] array = new byte[1024];
        long beginTime = System.currentTimeMillis();
        System.out.println("Read begin:" + beginTime);
        try {
            int readLength = ips.read(array);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            long endTime = System.currentTimeMillis();
            System.out.println("Read end:" + endTime);
            System.out.println("Read consume:" + (endTime - beginTime));
        }
    }

}
