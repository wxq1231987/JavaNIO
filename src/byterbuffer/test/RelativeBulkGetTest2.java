package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * ��֤get(byte[], offset, length)��length���ܳ���byte[].length - offset, �����׳�IndexOutOfBoundsException
 * ��֤get(byte[], offset, length)��offset���ܳ���byte[].length�������׳�IndexOutOfBoundsException
 * ��֤get(byte[], offset, length)��length - offset���ܳ���ByteBuffer��remaining,����BufferUnderflowException
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
