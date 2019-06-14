package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class DuplicateTest2 {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer buffer1 = ByteBuffer.wrap(array);
        ByteBuffer buffer2 = buffer1.duplicate();
        System.out.println("Buffer1 capacity=" + buffer1.capacity() + ", position="
                + buffer1.position() + ", limit=" + buffer1.limit());
        System.out.println("Buffer2 capacity=" + buffer2.capacity() + ", position="
                + buffer2.position() + ", limit=" + buffer2.limit());
        buffer2.put(1, (byte) 6);
        buffer2.position(2);
        System.out.println("Buffer1 capacity=" + buffer1.capacity() + ", position="
                + buffer1.position() + ", limit=" + buffer1.limit());
        System.out.println("Buffer2 capacity=" + buffer2.capacity() + ", position="
                + buffer2.position() + ", limit=" + buffer2.limit());
        for (int i = buffer1.position();i < buffer1.limit();i++) {
            System.out.print(buffer1.get() + " ");
        }
    }

}
