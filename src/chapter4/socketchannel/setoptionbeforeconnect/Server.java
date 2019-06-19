package chapter4.socketchannel.setoptionbeforeconnect;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8088);
		Socket client = server.accept();
		InputStream ins = client.getInputStream();
		int readLength = -1;
		byte[] buf = new byte[1024];
		while ((readLength=ins.read(buf)) != -1) {
			System.out.println(new String(buf, 0, readLength));
		}
		client.close();
		server.close();
	}

}
