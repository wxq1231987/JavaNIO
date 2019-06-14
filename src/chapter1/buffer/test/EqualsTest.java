package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class EqualsTest {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
        ByteBuffer buffer2 = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
        buffer1.position(1);
        buffer1.limit(4);
        buffer2.position(1);
        buffer2.limit(4);
        System.out.println(buffer1.equals(buffer2));

        ByteBuffer buffer3 = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
        ByteBuffer buffer4 = ByteBuffer.wrap(new byte[]{1, 2, 10, 4, 5, 6, 7, 8});
        buffer3.position(1);
        buffer3.limit(4);
        buffer4.position(1);
        buffer4.limit(4);
        System.out.println(buffer3.equals(buffer4));
    }
}
