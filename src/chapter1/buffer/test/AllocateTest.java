package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class AllocateTest {
    public static void main(String[] args) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("ByteBuffer 容量不能为负数");
        }
    }
}
