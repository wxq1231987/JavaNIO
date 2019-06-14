package byterbuffer.test;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AsShortBufferTest {
    /**
     * 验证asTypeBuffer的position从ByteBuffer的当前位置开始，limit和capacity为
     * ByteBuffer的remaing除以2或4或8
     * @param args
     */
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		ShortBuffer shortBuffer = buffer.asShortBuffer();
		System.out.println("A Before asShortBuffer position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		System.out.println("A After asShortBuffer position=" + shortBuffer.position() + ", limit="
				+ shortBuffer.limit() + ", capacity=" + shortBuffer.capacity());
		buffer.position(2);
		ShortBuffer shortBuffer1 = buffer.asShortBuffer();
		System.out.println("B Before asShortBuffer position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		System.out.println("B After asShortBuffer position=" + shortBuffer1.position() + ", limit="
				+ shortBuffer1.limit() + ", capacity=" + shortBuffer1.capacity());
	    printBufferContent(shortBuffer1);
	}
	
	public static void printBufferContent(ShortBuffer buffer) {
		for (int i = buffer.position();i < buffer.limit();i++) {
			System.out.print((short)buffer.get() + " ");
		}
	}

}
