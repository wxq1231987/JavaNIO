package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class ClearTest {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        System.out.println("A position=" + buffer.position() + ",limit="
                + buffer.limit() + ",capacity=" + buffer.capacity());
        buffer.position(1);
        buffer.limit(2);
        System.out.println("B position=" + buffer.position() + ",limit="
                + buffer.limit() + ",capacity=" + buffer.capacity());
        buffer.clear();
        System.out.println("C position=" + buffer.position() + ",limit="
                + buffer.limit() + ",capacity=" + buffer.capacity());
    }
}
