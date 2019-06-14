package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class CompactTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6});
        System.out.println("A position=" + buffer.position());
        System.out.println(buffer.get());
        System.out.println("B position=" + buffer.position());
        System.out.println(buffer.get());
        System.out.println("C position=" + buffer.position());
        buffer.compact();
        System.out.println("D position=" + buffer.position());
        buffer.flip();
        byte[] array = buffer.array();
        for (int i = 0;i < buffer.limit();i++) {
            System.out.print(array[i] + " ");
        }
    }

}
