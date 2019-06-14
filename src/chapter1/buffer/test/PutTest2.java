package chapter1.buffer.test;

import java.nio.ByteBuffer;
/**
 * put(byte[], offset, length)相对批量操作
 * @author Wang XuQin
 *
 */
public class PutTest2 {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int getArrayIndex = 0;
        while (getArrayIndex < array.length) {
            int readLength =  Math.min(buffer.remaining(), array.length - getArrayIndex);
            buffer.put(array, getArrayIndex, readLength);
            byte[] readArr = buffer.array();
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print(readArr[i] + " ");
            }
            getArrayIndex = getArrayIndex + readLength;
            System.out.println();
            buffer.clear();
        }
    }

}
