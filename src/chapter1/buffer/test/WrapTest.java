package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class WrapTest {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer buffer1 = ByteBuffer.wrap(array);
        ByteBuffer buffer2 = ByteBuffer.wrap(array, 2, 4);
        System.out.println("buffer1 position=" + buffer1.position() + ", capacity="
                + buffer1.capacity() + ", limit=" + buffer1.limit());
        System.out.println();
        System.out.println("buffer2 position=" + buffer2.position() + ", capacity="
                + buffer2.capacity() + ", limit=" + buffer2.limit());
        for (int i = buffer1.position(); i < buffer1.limit(); i++) {
            System.out.print(buffer1.get() + " ");
        }
        System.out.println();
        for (int i = buffer2.position(); i < buffer2.limit(); i++) {
            System.out.print(buffer2.get() + " ");
        }
    }

}
