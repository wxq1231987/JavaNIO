package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class AsReadOnlyBufferTest {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6};
        ByteBuffer buffer1 = ByteBuffer.wrap(array);
        ByteBuffer buffer2 = buffer1.asReadOnlyBuffer();
        System.out.println("Buffer1 isReadOnly:" + buffer1.isReadOnly());
        System.out.println("Buffer2 isReadOnly:" + buffer2.isReadOnly());
        buffer2.put((byte) 123);
    }

}
