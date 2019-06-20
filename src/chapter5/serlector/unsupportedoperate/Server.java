package chapter5.serlector.unsupportedoperate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.ServerSocketChannel;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		server.bind(new InetSocketAddress("localhost", 8088));
		server.configureBlocking(false);
		
		Selector sel = Selector.open();
		SelectionKey key = server.register(sel, SelectionKey.OP_ACCEPT);
		sel.keys().remove(key);
	}

}
