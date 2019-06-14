package chapter1.buffer.test;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.putInt(123);
        System.out.println("A" + byteBuffer.position());
        byteBuffer.putInt(145);
        System.out.println("B" + byteBuffer.position());
        IntBuffer intBuffer = IntBuffer.allocate(10);
        intBuffer.put(156);
        System.out.println("C" + intBuffer.position());
        intBuffer.put(166);
        System.out.println("D" + intBuffer.position());
    }

}
