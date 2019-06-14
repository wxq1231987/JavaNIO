package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class MarkTest {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        buffer.reset();
    }
}
