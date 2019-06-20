package chapter5.serlector.newcreatekeysetisnull;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

/*
 * 验证新创建的Selector，3个集合都是空集合
 */
public class Test {
    public static void main(String[] args) throws IOException  {
    	Selector sel = Selector.open();
		Set<SelectionKey> keys = sel.keys();
		Set<SelectionKey> selectedKeys = sel.selectedKeys();
		System.out.println("keys.size()=" + keys.size());
		System.out.println("selectedKeys.size()=" + selectedKeys.size());
	}
}
