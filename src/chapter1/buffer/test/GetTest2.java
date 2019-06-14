package chapter1.buffer.test;

import java.nio.ByteBuffer;

/**
 * get批量操作
 * @author Wang XuQin
 *
 */
public class GetTest2 {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        byte[] readArr = new byte[5];
        while (buffer.hasRemaining()) {
            int readLength = Math.min(buffer.remaining(), readArr.length);
            buffer.get(readArr, 0, readLength);
            for (int i = 0; i < readLength; i++) {
                System.out.print(readArr[i] + " ");
            }
            System.out.println();
        }
    }

}
