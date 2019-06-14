package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * ��֤get(byte[])�Ǵ�ByteBuffer�ĵ�ǰλ�ÿ�ʼ��ȡ����
 * ��֤ByteBuffer��remainingС��byte[]����ĳ��ȣ�ִ��get(byte[])���������׳�BufferUnderflowException
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
