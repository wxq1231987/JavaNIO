package chapter5.serlector.selectionkey.isvalid;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		server.configureBlocking(false);
		
		Selector sel = Selector.open();
		SelectionKey key = server.register(sel, SelectionKey.OP_ACCEPT);
		
		System.out.println(key.isValid());
		key.cancel();
		System.out.println(key.isValid());
		
		server.close();

	}

}
