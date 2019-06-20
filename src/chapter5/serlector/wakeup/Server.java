package chapter5.serlector.wakeup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
	private static Selector sel;
	public static void main(String[] args) throws IOException {
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sel.wakeup();
				Set<SelectionKey> set1 = sel.keys();
				Set<SelectionKey> set2 = sel.selectedKeys();
				System.out.println("After wakeup");
				System.out.println("set1.size()=" + set1.size());
				System.out.println("set2.size()=" + set2.size());
			}
		};
		t.start();

		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.bind(new InetSocketAddress("localhost", 8088));
		serverChannel.configureBlocking(false);
		
		sel = Selector.open();
		SelectionKey key = serverChannel.register(sel, SelectionKey.OP_ACCEPT);
		int keyCount = sel.select();
		System.out.println("KeyCount:" + keyCount);
		Set<SelectionKey> selectedKeys = sel.selectedKeys();
		Iterator<SelectionKey> it = selectedKeys.iterator();
		while (it.hasNext()) {
			SelectionKey selectedKey = it.next();
			if (selectedKey.isAcceptable()) {
				ServerSocketChannel server = (ServerSocketChannel) selectedKey.channel();
				Socket socket = server.socket().accept();
				socket.close();
			}
		}
		serverChannel.close();
		System.out.println("Main end");

	}

}
