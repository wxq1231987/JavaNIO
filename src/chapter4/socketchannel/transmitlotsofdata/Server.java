package chapter4.socketchannel.transmitlotsofdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) throws IOException {
		SocketChannel client = null;
		ServerSocketChannel server = ServerSocketChannel.open();
		server.configureBlocking(false);
		server.bind(new InetSocketAddress("localhost", 8088));
		Selector sel = Selector.open();
		server.register(sel, SelectionKey.OP_ACCEPT);
		boolean isRun = true;
		while (isRun == true) {
			sel.select();
			Set<SelectionKey> set = sel.selectedKeys();
			Iterator<SelectionKey> it = set.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				it.remove();
				if (key.isAcceptable()) {
					client = server.accept();
					client.configureBlocking(false);
					client.register(sel, SelectionKey.OP_WRITE);
				}
				if (key.isWritable()) {
					SocketChannel socketChannel = (SocketChannel) key.channel();
					FileInputStream fis = new FileInputStream("C:\\Users\\Tina\\Downloads"
							+ "\\apache-tomcat-8.5.42-windows-x64.zip");
					FileChannel fileChannel = fis.getChannel();
					ByteBuffer buffer = ByteBuffer.allocate(4096);
					int count = 0;
					while (fileChannel.position() < fileChannel.size()) {
						System.out.println("Count:" + count + ", ReadLength:" + buffer.position());
						fileChannel.read(buffer);
						buffer.flip();
						socketChannel.write(buffer);
						buffer.clear();
					}
					fileChannel.close();
					socketChannel.close();
				}
			}
		}
	}

}
