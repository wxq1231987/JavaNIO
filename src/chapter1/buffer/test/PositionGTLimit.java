package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PositionGTLimit {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        buffer.position(3);
        System.out.println("A position=" + buffer.position());
        buffer.limit(2);
        System.out.println("B position=" + buffer.position());
    }
}
