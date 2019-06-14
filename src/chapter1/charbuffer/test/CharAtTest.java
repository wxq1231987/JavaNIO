package chapter1.charbuffer.test;

import java.nio.CharBuffer;

public class CharAtTest {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.append("abcde");
        buffer.position(0);
        System.out.println(buffer.charAt(0));
        System.out.println(buffer.charAt(1));
    }

}
