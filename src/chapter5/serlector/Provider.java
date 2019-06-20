package chapter5.serlector;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

public class Provider {

	public static void main(String[] args) throws IOException {
		SelectorProvider provider1 = SelectorProvider.provider();
		SelectorProvider provider2 = Selector.open().provider();
		System.out.println(provider1 == provider2);

	}

}
