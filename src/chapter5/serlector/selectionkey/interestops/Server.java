package chapter5.serlector.selectionkey.interestops;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		server.configureBlocking(false);
		
		SocketChannel client1 = SocketChannel.open();
		client1.configureBlocking(false);
		
		SocketChannel client2 = SocketChannel.open();
		client2.configureBlocking(false);
		
		Selector sel = Selector.open();
		
		SelectionKey key1 = server.register(sel, SelectionKey.OP_ACCEPT);
		SelectionKey key2 = client1.register(sel, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);
		SelectionKey key3 = client2.register(sel, SelectionKey.OP_CONNECT | SelectionKey.OP_READ 
				| SelectionKey.OP_WRITE);

		System.out.println(~key1.interestOps() & SelectionKey.OP_ACCEPT);
		System.out.println(~key1.interestOps() & SelectionKey.OP_CONNECT);
		System.out.println(~key1.interestOps() & SelectionKey.OP_READ);
		System.out.println(~key1.interestOps() & SelectionKey.OP_WRITE);
		
		System.out.println();
		
		System.out.println(~key2.interestOps() & SelectionKey.OP_ACCEPT);
		System.out.println(~key2.interestOps() & SelectionKey.OP_CONNECT);
		System.out.println(~key2.interestOps() & SelectionKey.OP_READ);
		System.out.println(~key2.interestOps() & SelectionKey.OP_WRITE);
		
		System.out.println();
		
		System.out.println(~key3.interestOps() & SelectionKey.OP_ACCEPT);
		System.out.println(~key3.interestOps() & SelectionKey.OP_CONNECT);
		System.out.println(~key3.interestOps() & SelectionKey.OP_READ);
		System.out.println(~key3.interestOps() & SelectionKey.OP_WRITE);
	}

}
