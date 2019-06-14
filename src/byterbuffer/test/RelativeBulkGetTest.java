package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证get(byte[])是从ByteBuffer的当前位置开始获取数据
 * 验证ByteBuffer的remaining小于byte[]数组的长度，执行get(byte[])方法将会抛出BufferUnderflowException
 * @author Tina
 *
 */
public class RelativeBulkGetTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10});
		byte[] buf1 = new byte[5];
		buffer.position(5);
		System.out.println("Before get(byte[]) position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
        buffer.get(buf1);
        System.out.println("After get(byte[]) position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
        for (int i = 0;i < buf1.length;i++) {
        	System.out.print(buf1[i] + " ");
        }
        buffer.rewind();
        buffer.position(8);
        buffer.get(buf1);
	}

}
