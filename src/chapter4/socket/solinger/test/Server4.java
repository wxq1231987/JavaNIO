package chapter4.socket.solinger.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    /**
     * setSoLinger(true, 1)传输数据多于1s，close阻塞的时间就是数据传输的时间，正常进行4次挥手
     * @param args
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        StringBuffer sbf = new StringBuffer(3000000);
        for (int i = 0;i < 3000000;i++) {
            sbf.append("1");
        }
        sbf.append("end!");
        System.out.println("Server填充完毕");
        ServerSocket server = new ServerSocket(8088);
        Socket client = server.accept();
        client.setSendBufferSize(3000000);
        client.setSoLinger(true, 1);

        OutputStream ops = client.getOutputStream();
        ops.write(sbf.toString().getBytes());

        long beginTime = 0;
        long endTime = 0;
        beginTime = System.currentTimeMillis();
        client.close();
        endTime = System.currentTimeMillis();
        System.out.println(endTime + "-" + beginTime + "=" + (endTime - beginTime));
        Thread.sleep(Integer.MAX_VALUE);
        server.close();
    }

}
