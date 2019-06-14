package chapter4.socket.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConstructTest {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("www.csdnsdfsdfsd.net", 80);
            System.out.println("Client connect scdn successly");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
