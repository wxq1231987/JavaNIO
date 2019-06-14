package byterbuffer.test;

import java.nio.ByteBuffer;

public class ByteBufferUtil {
	public static void printByteBuffer(ByteBuffer buffer) {
		for (int i = buffer.position();i < buffer.limit();i++) {
			System.out.print(buffer.get() + " ");
		}
		System.out.println();
	}
}
