package chapter4.socket.solinger.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    /**
     * setSoLinger(true, 10)传输数据少于10s，close阻塞的时间就是数据传输的时间，正常进行4次挥手
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        StringBuffer sbf = new StringBuffer(1000000);
        for (int i = 0;i < 1000000;i++) {
            sbf.append("1");
        }
        sbf.append("end!");
        System.out.println("Server填充完毕");
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        client.setSendBufferSize(100);
        client.setSoLinger(true, 10);
        
        OutputStream ops = client.getOutputStream();
        ops.write(sbf.toString().getBytes());

        long beginTime = 0;
        long endTime = 0;
        beginTime = System.currentTimeMillis();
        client.close();
        endTime = System.currentTimeMillis();
        System.out.println(endTime + "-" + beginTime + "=" + (endTime - beginTime));
        server.close();
    }

}
