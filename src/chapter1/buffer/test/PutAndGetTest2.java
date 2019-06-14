package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class PutAndGetTest2 {

    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] array2 = new byte[]{55, 66, 77, 88};
        ByteBuffer buffer1 = ByteBuffer.allocate(9);
        buffer1.put(array);
        buffer1.position(6);
        buffer1.put(array2, 1, 3);
        System.out.print("A=");
        byte[] getByte = buffer1.array();
        for (int i = 0; i < getByte.length; i++) {
            System.out.print(getByte[i] + " ");
        }
        System.out.println();
    }

}
