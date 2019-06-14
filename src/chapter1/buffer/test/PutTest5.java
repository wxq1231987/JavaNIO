package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PutTest5 {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        buffer.put(2, (byte) 127);
        System.out.println("position= " + buffer.position());
        byte[] getOutArr = new byte[buffer.capacity()];
        buffer.get(getOutArr, 0, getOutArr.length);
        for (int i = 0; i < getOutArr.length; i++) {
            System.out.print(getOutArr[i] + " ");
        }
    }
}
