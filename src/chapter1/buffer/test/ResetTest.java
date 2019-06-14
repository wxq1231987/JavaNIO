package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class ResetTest {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        System.out.println("A position=" + buffer.position());
        buffer.position(2);
        System.out.println("B position=" + buffer.position());
        buffer.mark();
        buffer.position(3);
        System.out.println("C position=" + buffer.position());
        buffer.reset();
        System.out.println("D position=" + buffer.position());
    }
}
