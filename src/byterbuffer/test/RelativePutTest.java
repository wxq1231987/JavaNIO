package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证put(byte)从ByteBuffer的当前位置开始写入
 * 验证ByteBuffer的position=limit时，put(byte)会抛出BufferOverflowException异常
 * @author Tina
 *
 */
public class RelativePutTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10});
		buffer.position(9);
		System.out.println("Before put(byte) position=" + buffer.position() + ", limit="
				+ buffer.limit());
		buffer.put((byte) 11);
		System.out.println("After put(byte) position=" + buffer.position() + ", limit="
				+ buffer.limit());
		buffer.rewind();
		ByteBufferUtil.printByteBuffer(buffer);
		System.out.println("After print buffer position=" + buffer.position() + ", limit="
				+ buffer.limit());
		buffer.put((byte) 12);
	}
}
