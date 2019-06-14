package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class FlipTest {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        buffer.position(2);
        System.out.println("A position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.mark();
        buffer.flip();
        System.out.println("B position=" + buffer.position() + ", limit="
                + buffer.limit());
        buffer.reset();
    }
}
