package chapter4.socket.oobinline.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8088);
            OutputStream ops = client.getOutputStream();
            System.out.println("CLient OOBInlin:" + client.getOOBInline());
            OutputStreamWriter writer = new OutputStreamWriter(ops);
            client.sendUrgentData(97);
            writer.write("zzzzzzzzzzzzz");
            client.sendUrgentData(98);
            client.sendUrgentData(99);
            writer.flush();
            client.sendUrgentData(100);
            ops.close();
            client.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
