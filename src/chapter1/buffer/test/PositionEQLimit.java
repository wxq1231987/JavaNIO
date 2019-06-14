package chapter1.buffer.test;

import java.nio.CharBuffer;

public class PositionEQLimit {
    public static void main(String[] args) {
        char[] array = new char[]{'a', 'b', 'c', 'd'};
        CharBuffer buffer = CharBuffer.wrap(array);
        buffer.position(4);
        buffer.put('e');
    }
}
