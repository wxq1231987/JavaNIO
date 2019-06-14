package chapter1.buffer.test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class OrderTest {

    public static void main(String[] args) {
        int value = 12345678;
        ByteBuffer buffer = ByteBuffer.allocate(4);
        System.out.print(buffer.order() + " ");
        buffer.putInt(value);
        byte[] arr1 = buffer.array();
        for (int i = 0;i < arr1.length;i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        ByteBuffer buffer2 = ByteBuffer.allocate(4);
        buffer2.order(ByteOrder.LITTLE_ENDIAN);
        buffer2.putInt(value);
        System.out.print(buffer2.order() + " ");
        byte[] arr2 = buffer2.array();
        for (int i = 0;i < arr2.length;i++) {
            System.out.print(arr2[i] + " ");
        }
    }

}
