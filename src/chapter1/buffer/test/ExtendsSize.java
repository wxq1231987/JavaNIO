package chapter1.buffer.test;

import java.nio.ByteBuffer;

public class ExtendsSize {
    public static ByteBuffer extendsSize(ByteBuffer buffer, int extendsSize) {
        ByteBuffer newByteBuffer = ByteBuffer.allocate(buffer.capacity() + extendsSize);
        newByteBuffer.put(buffer);
        return newByteBuffer;
    }
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5});
        ByteBuffer newBuffer = extendsSize(buffer, 2);
        byte[] newArr = newBuffer.array();
        for (int i = 0;i < newArr.length;i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
