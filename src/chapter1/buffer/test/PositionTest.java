package chapter1.buffer.test;

import java.nio.CharBuffer;
/**
 * verify position is the index of next read or write 
 * @author Wang XuQin
 *
 */
public class PositionTest {

    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'e', 'f', 'g'};
        CharBuffer buffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity=" + buffer.position() + ", limit=" + buffer.limit() 
             + ", position=" + buffer.position());
        buffer.position(2);
        System.out.println("B capacity=" + buffer.position() + ", limit=" + buffer.limit() 
        + ", position=" + buffer.position());
        buffer.put('h');
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
    }

}
