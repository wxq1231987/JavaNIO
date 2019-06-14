package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PutAndGetTest {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        System.out.println("A capacity=" + buffer1.capacity() + ", limit=" + buffer1.limit()
              + ", position=" + buffer1.position());
        buffer1.put((byte) 123);
        System.out.println("B capacity=" + buffer1.capacity() + ", limit=" + buffer1.limit()
              + ", position=" + buffer1.position());
        buffer1.put((byte) 124);
        System.out.println("C capacity=" + buffer1.capacity() + ", limit=" + buffer1.limit()
              + ", position=" + buffer1.position());
        buffer1.rewind();
        System.out.println("D capacity=" + buffer1.capacity() + ", limit=" + buffer1.limit()
              + ", position=" + buffer1.position());
        System.out.println(buffer1.get());
        System.out.println("E capacity=" + buffer1.capacity() + ", limit=" + buffer1.limit()
              + ", position=" + buffer1.position());
        System.out.println(buffer1.get());
        System.out.println("F capacity=" + buffer1.capacity() + ", limit=" + buffer1.limit()
              + ", position=" + buffer1.position());
    }
}
