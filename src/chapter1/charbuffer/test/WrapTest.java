package chapter1.charbuffer.test;

import java.nio.CharBuffer;

public class WrapTest {
/**
 * wrap(CharSequence, start, end)是只读的
 * @param args
 */
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.wrap("abcdefg", 3, 5);
        System.out.println("Bubffer position=" + buffer.position() + ", limit="
                + buffer.limit() + ", capacity=" + buffer.capacity());
        buffer.put('a');
    }

}
