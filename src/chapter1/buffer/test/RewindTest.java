package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class RewindTest {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println();
        System.out.println("A position= " + buffer.position() + ", limit="
                + buffer.limit());
        buffer.rewind();
        System.out.println("B position= " + buffer.position() + ", limit="
                + buffer.limit());
    }

}
