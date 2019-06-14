package chapter4.socket.halfread.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8088);
            client = server.accept();
            InputStream ins = client.getInputStream();
            System.out.println("A=" + ins.available());
            byte[] arr = new byte[2];
            int readLength = ins.read(arr);
            System.out.println("server取得的数据:" + new String(arr, 0, readLength));
            client.shutdownInput(); // 静默丢弃其他数据
            readLength = ins.read(arr); // -1;
            System.out.println("shutdownInput readLength:" + readLength);
            client.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("IsInputShutdown:" + client.isInputShutdown());
        } finally {
            try {
                client.close();
                server.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
