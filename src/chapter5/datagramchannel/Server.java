package chapter5.datagramchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) throws IOException {
		DatagramChannel receiver = DatagramChannel.open();
		receiver.configureBlocking(false);
		receiver.bind(new InetSocketAddress("localhost", 8088));
		
		Selector sel = Selector.open();
		SelectionKey registerKey = receiver.register(sel, SelectionKey.OP_READ);
		
		boolean isRun = true;
		while (isRun) {
			sel.select();
			Set<SelectionKey> set = sel.selectedKeys();
			Iterator<SelectionKey> it = set.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isReadable()) {
					receiver = (DatagramChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					receiver.receive(buffer);
					System.out.println(new String(buffer.array(), 0, buffer.position()));
				}
				it.remove();
			}
			receiver.close();
		}

	}

}
