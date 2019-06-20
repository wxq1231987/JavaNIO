package chapter5.serlector.closemoredetail;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;


public class Server2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocketChannel server1= ServerSocketChannel.open();
		server1.bind(new InetSocketAddress("localhost", 8088));
		server1.configureBlocking(false);
		
		ServerSocketChannel server2= ServerSocketChannel.open();
		server2.bind(new InetSocketAddress("localhost", 8089));
		server2.configureBlocking(false);

		Selector sel = Selector.open();
		server1.register(sel, SelectionKey.OP_ACCEPT);
		server2.register(sel, SelectionKey.OP_ACCEPT);
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Socket client1 = new Socket("localhost", 8088);
					OutputStream ops1 = client1.getOutputStream();
					ops1.write("我是客户端1发送数据到8088".getBytes());
					client1.close();
					
					Socket client2 = new Socket("localhost", 8089);
					OutputStream ops2 = client2.getOutputStream();
					ops2.write("我是客户端2发送数据到8089".getBytes());
					client2.close();
					System.out.println();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t1.start();
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Set<SelectionKey> keys = sel.keys();
				Set<SelectionKey> selectedKeys = sel.selectedKeys();
				System.out.println("select()方法执行第2次的信息：");
				System.out.println("keys.size()=" + keys.size());
				System.out.println("selectedKeys.size()=" + selectedKeys.size());
			}
		};
		t2.start();
		
		Thread.sleep(1000);
		boolean isRun = true;
		while (isRun) {
			int keyCount = sel.select();
			Set<SelectionKey> keys = sel.keys();
			Set<SelectionKey> selectedKeys = sel.selectedKeys();
			System.out.println("Before Cancel:");
			System.out.println("keys.size()=" + keys.size());
			System.out.println("selectedKeys.size()=" + selectedKeys.size());
			System.out.println();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			while (it.hasNext()) {
				SelectionKey selectedKey = it.next();
				if (selectedKey.isAcceptable()) {
					ServerSocketChannel channel1 = (ServerSocketChannel) selectedKey.channel();
					ServerSocket serverSocket = channel1.socket();
					Socket socket = serverSocket.accept();
					InputStream ins = socket.getInputStream();
					byte[] arr = new byte[1024];
					int readLength = -1;
					while ((readLength=ins.read(arr)) != -1) {
						System.out.println(new String(arr, 0, readLength));
					}
					ins.close();
					socket.close();
					//it.remove();
					if (serverSocket.getLocalPort() == 8088) {
						server1.close();
					}
				}
			}
		}
		server1.close();
		server2.close();
	}

}
