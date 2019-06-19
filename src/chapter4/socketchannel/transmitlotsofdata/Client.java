package chapter4.socketchannel.transmitlotsofdata;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client {

	public static void main(String[] args) throws IOException {
		SocketChannel client = SocketChannel.open();
		client.configureBlocking(false);
		client.connect(new InetSocketAddress("localhost", 8088));
		Selector sel = Selector.open();
		client.register(sel, SelectionKey.OP_CONNECT);
		boolean isRun = true;
		while (isRun == true) {
			sel.select();
			Set<SelectionKey> set = sel.selectedKeys();
			Iterator<SelectionKey> it = set.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				it.remove();
				if (key.isConnectable()) {
					while (!client.finishConnect()) {
					}
					client.register(sel, SelectionKey.OP_READ);
				}
				if (key.isReadable()) {
					RandomAccessFile fos = new RandomAccessFile("E:\\wangxuqin\\software", "rw");
					FileChannel fileChannel = fos.getChannel();
					ByteBuffer buffer = ByteBuffer.allocate(4096);
					int count = 0;
					int readLength = -1;
					while ((readLength = client.read(buffer)) != -1) {
						count += readLength;
						System.out.println("Count:" + count + ", ReadLength:" + readLength);
						buffer.flip();
						fileChannel.write(buffer);
						buffer.clear();
					}
					fileChannel.close();
					fos.close();
					client.close();
				}
			}
		}

	}

}
