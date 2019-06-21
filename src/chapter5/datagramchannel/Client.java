package chapter5.datagramchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Client {

	public static void main(String[] args) throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(false);
		
		Selector sel = Selector.open();
		SelectionKey registerKey = channel.register(sel, SelectionKey.OP_WRITE);
		int keyCount = sel.select();
		Set<SelectionKey> set = sel.selectedKeys();
		Iterator<SelectionKey> it = set.iterator();
		while (it.hasNext()) {
			SelectionKey key = it.next();
			if (key.isWritable()) {
				channel = (DatagramChannel) key.channel();
				channel.send(ByteBuffer.wrap("我来自客户端".getBytes()), new InetSocketAddress("localhost", 8088));
				channel.close();
			}
		}
		System.out.println("Client end");

	}

}
