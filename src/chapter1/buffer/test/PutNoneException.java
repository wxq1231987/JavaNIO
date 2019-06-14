package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PutNoneException {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        int offset = 0;
        while (offset < array.length) {
            int readLength = Math.min(buffer1.remaining(), array.length);
            buffer1.flip();
            
        }
    }
}
