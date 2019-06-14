package chapter4.socket.solinger.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * setSoLinger(true, 0)连接关闭立即返回，丢弃数据包，并且发送RST给客户端
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        System.out.println("A socket.getSoLinger()=" + client.getSoLinger());
        client.setSoLinger(true, 0);
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
