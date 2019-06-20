package chapter5.serlector.selectfornow;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
/**
 * 验证selector.selectNow()方法立即返回
 * @author Tina
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		server.bind(new InetSocketAddress("localhost", 8088));
		server.configureBlocking(false);
		
		Selector sel = Selector.open();
		SelectionKey key = server.register(sel, SelectionKey.OP_ACCEPT);
		boolean isRun = true;
		while (isRun == true) {
			System.out.println("IsRun " + System.currentTimeMillis());
			//sel.select(5000);
			sel.selectNow();
			Set<SelectionKey> set = sel.selectedKeys();
			Iterator<SelectionKey> it = set.iterator();
			while (it.hasNext()) {
				SelectionKey selectedKey = it.next();
				if (selectedKey.isAcceptable()) {
					ServerSocketChannel serverChannel = (ServerSocketChannel) selectedKey.channel();
					Socket socket = serverChannel.socket().accept();
					socket.close();
				}
				it.remove();
			}
		}
		server.close();
	}

}
