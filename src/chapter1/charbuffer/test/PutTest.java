package chapter1.charbuffer.test;

import java.io.IOException;
import java.nio.CharBuffer;

public class PutTest {
    public static void main(String[] args) throws IOException {
        CharBuffer buffer = CharBuffer.allocate(15);
        buffer.append("ab12345");
        buffer.put("cde");
        buffer.rewind();
        for (int i = 0;i < buffer.limit();i++) {
            System.out.print(buffer.get());
        }
        System.out.println();
        buffer.position(1);
        CharBuffer buffer2 = CharBuffer.allocate(4);
        buffer.read(buffer2);
        buffer2.rewind();
        System.out.println("Buffer2 position=" + buffer2.position() + ", limit=" + buffer2.limit());
        for (int i = buffer2.position();i < buffer2.limit();i++) {
            System.out.print(buffer2.get());
        }
        System.out.println();
        System.out.println("Buffer position=" + buffer.position() + ", limit=" + buffer.limit());
        CharBuffer buffer3 = buffer.subSequence(0, 2);
        for (int i = buffer3.position();i < buffer3.limit();i++) {
            System.out.print(buffer3.get() + " ");
        }
    }
}
