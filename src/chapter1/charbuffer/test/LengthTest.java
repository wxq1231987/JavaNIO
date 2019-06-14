package chapter1.charbuffer.test;

import java.nio.CharBuffer;

public class LengthTest {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.wrap("abcdefg");
        System.out.println("A position=" + buffer.position() + ", limit="
                + buffer.limit() + ", capacity=" + buffer.capacity() + ", remaining="
                + buffer.remaining());
        System.out.println("B length=" + buffer.length());
        buffer.position(2);
        System.out.println("C position=" + buffer.position() + ", limit="
                + buffer.limit() + ", capacity=" + buffer.capacity() + ", remaining="
                + buffer.remaining());
        System.out.println("D length=" + buffer.length());
    }

}
