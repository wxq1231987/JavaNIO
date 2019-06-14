package chapter1.buffer.test;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class PutTest4 {
    /**
     * put(byte[])测试
     * @param args
     */
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ByteBuffer buffer = ByteBuffer.allocate(4);
        int byteArrayIndex = 0;
        while (byteArrayIndex < array.length) {
            int readLength = Math.min(buffer.remaining(), array.length - byteArrayIndex);
            byte[] newByteArr = Arrays.copyOfRange(array, byteArrayIndex, byteArrayIndex + readLength);
            buffer.put(newByteArr);
            buffer.flip();
            byte[] getByte = buffer.array();
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print(getByte[i] + " ");
            }
            System.out.println();
            byteArrayIndex = byteArrayIndex + readLength;
            buffer.clear();
        }
    }

}
