package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PutTest3 {
    /**
     * put(byte[])相对批量操作
     * @param args
     */
    public static void main(String[] args) {
        byte[] array = new byte[]{3, 4, 5, 6, 7, 8};
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        buffer1.put((byte) 1);
        buffer1.put((byte) 2);
        System.out.println("A=" + buffer1.position());
        buffer1.put(array);
        System.out.println("B=" + buffer1.position());
    }

}
