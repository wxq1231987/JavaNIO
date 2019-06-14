package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证duplicate生成的ByteBuffer的position,limit,capacity和mark与原来的ByteBuffer完全一致
 * 验证duplicate生成的ByteBuffer的position,limit,capacity和mark与原来的ByteBuffer互相独立
 * @author Tina
 *
 */
public class DuplicateTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10});
		buffer.mark();
		buffer.position(2);
		buffer.limit(8);
		ByteBuffer duplicateBuffer = buffer.duplicate();
		System.out.println("Before duplicate position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		System.out.println("After duplicate position=" + duplicateBuffer.position() + ", limit="
				+ duplicateBuffer.limit() + ", capacity=" + duplicateBuffer.capacity());
		duplicateBuffer.reset();
		System.out.println("Duplicate buffer after reset position=" + duplicateBuffer.position() + ", limit="
				+ duplicateBuffer.limit() + ", capacity=" + duplicateBuffer.capacity());
		duplicateBuffer.position(5);
		System.out.println("Duplicate buffer after change position=" + duplicateBuffer.position() + ", limit="
				+ duplicateBuffer.limit() + ", capacity=" + duplicateBuffer.capacity());
	}

}
