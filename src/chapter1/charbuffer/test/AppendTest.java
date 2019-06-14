package chapter1.charbuffer.test;

import java.nio.CharBuffer;

public class AppendTest {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(15);
        buffer.append('a');
        System.out.println("A position=" + buffer.position());
        buffer.append("bcdefg");
        System.out.println("B position=" + buffer.position());
        buffer.append("hijklm", 3, 5);
        System.out.println("C position=" + buffer.position());
        char[] array = buffer.array();
        for (int i = 0;i < array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }
}