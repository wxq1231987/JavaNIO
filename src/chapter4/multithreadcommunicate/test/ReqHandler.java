package chapter4.multithreadcommunicate.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReqHandler extends Thread {
    private Socket socket;

    public ReqHandler(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream ips = null;
        InputStreamReader reader = null;
        try {
            ips = socket.getInputStream();
            reader = new InputStreamReader(ips);
            char[] cbuf = new char[1024];
            int readLength = -1;
            while ((readLength = reader.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
