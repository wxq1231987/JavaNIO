package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class DirectCompareUnDirect {
    private static int capacity = 190000000;
    public static void allocateTest() {
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) 123);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("UnDirect Memory:" + (endTime - startTime));
    }
    public static void allocateDirectTest() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(capacity);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) 123);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Direct Memory:" + (endTime - startTime));
    }
    public static void main(String[] args) {
        DirectCompareUnDirect test = new DirectCompareUnDirect();
        test.allocateDirectTest();
        test.allocateTest();
    }

}
