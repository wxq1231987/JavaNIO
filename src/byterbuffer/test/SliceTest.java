package byterbuffer.test;

import java.nio.ByteBuffer;

public class SliceTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10});
		buffer.position(2);
		System.out.println("Before slice position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		ByteBuffer sliceBuffer = buffer.slice();
		System.out.println("After slice position=" + sliceBuffer.position() + ", limit="
				+ sliceBuffer.limit() + ", capacity=" + sliceBuffer.capacity());
		ByteBufferUtil.printByteBuffer(buffer);
		ByteBufferUtil.printByteBuffer(sliceBuffer);
	}

}