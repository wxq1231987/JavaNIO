package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证AsReadOnlyBuffer的position、limit、capacity和mark与ByteBuffer一致
 * 验证AsReadOnlyBuffer是只读的
 * @author Tina
 *
 */
public class AsReadOnlyBufferTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		buffer.position(2);
		ByteBuffer readBuffer = buffer.asReadOnlyBuffer();
		System.out.println("Before asReadOnlyBuffer position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		System.out.println("After asReadOnlyBuffer position=" + readBuffer.position() + ", limit="
				+ readBuffer.limit() + ", capacity=" + readBuffer.capacity());
		readBuffer.put((byte) 11);
	}

}
