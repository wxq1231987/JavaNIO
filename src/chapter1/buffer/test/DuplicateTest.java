package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class DuplicateTest {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer buffer1 = ByteBuffer.wrap(array);
        buffer1.position(2);
        ByteBuffer buffer2 = buffer1.slice();
        ByteBuffer buffer3 = buffer1.duplicate();
        System.out.println("Buffer2 position=" + buffer2.position() + ", limit=" + buffer2.limit()
              + ", capacity=" + buffer2.capacity());
        System.out.println("Buffer3 position=" + buffer3.position() + ", limit=" + buffer3.limit()
        + ", capacity=" + buffer3.capacity());
    }

}
