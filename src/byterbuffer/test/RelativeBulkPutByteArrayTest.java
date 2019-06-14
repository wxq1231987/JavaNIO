package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证put(byte[])中的byte[].length不能大于ByteBuffer.remaing,否则抛出BufferOverflowException
 * 验证put(byte[])执行之后，ByteBuffer的position=position+byte[].length
 * 验证put(byte[], offset, length)中的length必须小于byte[].length - offset，否则抛出IndexOutOfBoundsException
 * 验证put(byte[], offset, length)中的length必须小于等于ByteBuffer.remaining，否则抛出BufferOverflowException
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
