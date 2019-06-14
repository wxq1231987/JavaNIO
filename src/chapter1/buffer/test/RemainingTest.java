package chapter1.buffer.test;

import java.nio.CharBuffer;
/**
 * verify remaining=limit-position
 * @author Wang XuQin
 *
 */
public class RemainingTest {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'd'};
        CharBuffer buffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity=" + buffer.capacity() + ", limit=" + buffer.limit()
           + ", position=" + buffer.position() + ", remaining=" + buffer.remaining());
        buffer.position(3);
        System.out.println("B capacity=" + buffer.capacity() + ", limit=" + buffer.limit()
           + ", position=" + buffer.position() + ", remaining=" + buffer.remaining());
    }
}
