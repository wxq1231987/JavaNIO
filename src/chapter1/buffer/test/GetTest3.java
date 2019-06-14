package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class GetTest3 {
    /**
     * get(byte[])
     * @param args
     */
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer buffer = ByteBuffer.wrap(array);
        int copyDataCount = 3;
        while (buffer.hasRemaining()) {
            int readLength = Math.min(buffer.remaining(), copyDataCount);
            byte[] copyArr = new byte[readLength];
            buffer.get(copyArr);
            for (int i = 0; i < copyArr.length; i++) {
                System.out.print(copyArr[i] + " ");
            }
            System.out.println();
        }
    }

}
