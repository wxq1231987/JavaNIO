package chapter5.datagramchannel.connect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.Iterator;
import java.util.Set;

/**
 * 练习datagramChannel.connect(SocketAddress)方法
 * @author Tina
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(false);
		channel.connect(new InetSocketAddress("localhost", 8088));
		Selector sel = Selector.open();
		SelectionKey key1 = channel.register(sel, SelectionKey.OP_WRITE);
		int keyCount = sel.select();
		Set<SelectionKey> set = sel.selectedKeys();
		Iterator<SelectionKey> it = set.iterator();
		while (it.hasNext()) {
			SelectionKey key = it.next();
			if (key.isWritable()) {
				ByteBuffer buffer = ByteBuffer.wrap("我是来自客户端准备发往服务端".getBytes());
				channel.write(buffer);
				channel.close();
			}
		}
	}
}
