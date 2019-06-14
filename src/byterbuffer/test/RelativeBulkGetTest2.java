package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证get(byte[], offset, length)的length不能超过byte[].length - offset, 否则抛出IndexOutOfBoundsException
 * 验证get(byte[], offset, length)的offset不能超过byte[].length，否则抛出IndexOutOfBoundsException
 * 验证get(byte[], offset, length)的length - offset不能超过ByteBuffer的remaining,否则BufferUnderflowException
 * @author Tina
 *
 */
public class RelativeBulkGetTest2 {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10});
		byte[] buf1 = new byte[10];
		//buffer.get(buf1, 5, 6);
		//buffer.get(buf1, 11, 4);
		buffer.position(2);
		buffer.get(buf1, 0, 10);
	}

}
