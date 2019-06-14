package chapter4.serversocket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerTest {
    /**
     * 尝试用ServerSocket建立一个Tomcat服务器
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8086);
        Socket client = server.accept();
        InputStream inputStream = client.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferReader = new BufferedReader(reader);

        String getString = "";
        while (!"".equals(getString = bufferReader.readLine())) {
            System.out.println(getString);
        }

        OutputStream outputStream = client.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        outputStream.write("<html><body><a href='http://www.baidu.com'>I am baidu.com</a></body></html>".getBytes());
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        client.close();
        server.close();
    }

}
