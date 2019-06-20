package chapter5.serlector;

import java.io.IOException;
import java.nio.channels.Selector;

public class CheckOpen {

	public static void main(String[] args) throws IOException {
		Selector sel = Selector.open();
		System.out.println(sel.isOpen());
		sel.close();
		System.out.println(sel.isOpen());
	}

}
