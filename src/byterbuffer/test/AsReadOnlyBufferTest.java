package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * ��֤AsReadOnlyBuffer��position��limit��capacity��mark��ByteBufferһ��
 * ��֤AsReadOnlyBuffer��ֻ����
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
