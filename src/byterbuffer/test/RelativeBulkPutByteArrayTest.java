package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * ��֤put(byte[])�е�byte[].length���ܴ���ByteBuffer.remaing,�����׳�BufferOverflowException
 * ��֤put(byte[])ִ��֮��ByteBuffer��position=position+byte[].length
 * ��֤put(byte[], offset, length)�е�length����С��byte[].length - offset�������׳�IndexOutOfBoundsException
 * ��֤put(byte[], offset, length)�е�length����С�ڵ���ByteBuffer.remaining�������׳�BufferOverflowException
 * @author Tina
 *
 */
public class RelativeBulkPutByteArrayTest {
    public static void main(String[] args) {
    	ByteBuffer buffer = ByteBuffer.allocate(10);
    	byte[] buf1 = new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10};
    	buffer.position(5);
    	//buffer.put(buf1);
    	buffer.rewind();
    	buffer.put(buf1);
    	System.out.println("After put(byte[]) position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
    	buffer.flip();
    	ByteBufferUtil.printByteBuffer(buffer);
    	
    	buffer.clear();
    	byte[] buf2 = new byte[]{1, 2, 3, 4, 5,
    			6, 7, 8, 9 , 10,
    			11, 12, 13, 14, 15};
    	System.out.println("Before put(byte[], offset, length) remaining=" + buffer.remaining());
    	buffer.put(buf2, 0, 10);
    	buffer.flip();
    	ByteBufferUtil.printByteBuffer(buffer);

    	/**
    	 * IndexOutOfBoundsException
    	 */
    	buffer.clear();
    	System.out.println("Before put(byte[], offset, length) remaining=" + buffer.remaining());
    	//buffer.put(buf2, 5, 14);

    	/**
    	 * BufferOverflowException
    	 */
    	buffer.clear();
    	buffer.position(5);
    	System.out.println("Before put(byte[], offset, length) remaining=" + buffer.remaining());
    	buffer.put(buf2, 6, 6);
	}
}
