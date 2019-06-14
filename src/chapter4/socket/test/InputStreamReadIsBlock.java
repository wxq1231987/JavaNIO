package chapter4.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class InputStreamReadIsBlock {

    public static void main(String[] args) {
        byte[] byteArray = new byte[1024];
        ServerSocket server;
        try {
            server = new ServerSocket(8088);
            System.out.println("accept begin");
            Socket socket = server.accept();
            System.out.println("accept end");
            InputStream ins = socket.getInputStream();
            System.out.println("InputStream read begin");
            int readLength = ins.read(byteArray);
            ins.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
