package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class IsReadOnlyTest {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        System.out.println("Is read only " + buffer.isReadOnly());
    }
}
