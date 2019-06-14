package chapter1.buffer.test;

import java.nio.CharBuffer;

public class LimitTest {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'd', 'e'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit());
        charBuffer.limit(3);
        System.out.println("B capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit());
        charBuffer.put(0, 'f');
        charBuffer.put(1, 'g');
        charBuffer.put(2, 'h');
        charBuffer.put(3, 'i');
        charBuffer.put(4, 'j');
    }
}
