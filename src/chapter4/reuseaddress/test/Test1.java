package chapter4.reuseaddress.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Thread server = new Thread() {
            @Override
            public void run() {
                ServerSocket serverSocket;
                try {
                    serverSocket = new ServerSocket();
                    serverSocket.setReuseAddress(false);
                    serverSocket.bind(new InetSocketAddress("localhost", 8088));
                    Socket socket = serverSocket.accept();
                    Thread.sleep(1000);
                    socket.close();
                    serverSocket.close();
                } catch (IOException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        server.start();
        Thread.sleep(500);

        Thread client = new Thread() {
            @Override
            public void run() {
                Socket socket = null;
                try {
                    socket = new Socket("localhost", 8088);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        client.start();
    }

}
