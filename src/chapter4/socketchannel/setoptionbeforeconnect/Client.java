package chapter4.socketchannel.setoptionbeforeconnect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

	public static void main(String[] args) throws IOException {
		SocketChannel client = SocketChannel.open();
		client.setOption(StandardSocketOptions.SO_SNDBUF, 1111);
		client.connect(new InetSocketAddress("localhost", 8088));
		client.write(ByteBuffer.wrap("我是来自客户端的数据".getBytes()));
		client.close();

	}

}
