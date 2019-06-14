package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class CompareTest {

    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
        ByteBuffer buffer2 = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
        buffer1.position(1);
        buffer1.limit(4);
        buffer2.position(1);
        buffer2.limit(5);
        System.out.println(buffer1.compareTo(buffer2));
    }

}
