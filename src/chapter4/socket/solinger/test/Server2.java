package chapter4.socket.solinger.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * setSoLinger(false, 12345)关闭连接立即返回，正常发送数据包和进行四次挥手
 * @author Wang XuQin
 *
 */
public class Server2 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        System.out.println("A socket.getSoLinger()=" + client.getSoLinger());
        client.setSoLinger(false, 12345);
        System.out.println("B socket.getSoLinger()=" + client.getSoLinger());

        OutputStream ops = client.getOutputStream();
        for (int i = 0;i < 10;i++) {
            ops.write(("12345678901234567890123456789012345678901234567890"
                    + "12345678901234567890123456789012345678901234567890"
                    + "12345678901234567890123456789012345678901234567890"
                    + "12345678901234567890123456789012345678901234567890"
                    + "12345678901234567890123456789012345678901234567890").getBytes());
        }
        ops.write("end!".getBytes());
        System.out.println("client close before=" + System.currentTimeMillis());
        ops.close();
        client.close();
        System.out.println("client close after=" + System.currentTimeMillis());
        server.close();
    }

}
