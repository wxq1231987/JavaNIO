package byterbuffer.test;

import java.nio.ByteBuffer;
/**
 * 验证get()方法执行后，position后移一位
 * 验证postion=limit时候，执行get方法，抛出BufferUnderflowException异常
 * @author Tina
 *
 */
public class RelativeGetTest {
    public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5,
				6, 7, 8, 9, 10});
		System.out.println("Before get() position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		System.out.println(buffer.get());
		System.out.println("After get() position=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity());
		buffer.position(buffer.limit());
		System.out.println(buffer.get());
		
	}
}
