package chapter1.buffer.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ToArrayTest {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{1, 2, 3, 4});
        ByteBuffer buffer2 = ByteBuffer.wrap(new byte[]{'a', 'b', 'c', 'd'});
        List<ByteBuffer> list = new ArrayList<ByteBuffer>();
        list.add(buffer1);
        list.add(buffer2);
        ByteBuffer[] bufferArr = new ByteBuffer[list.size()];
        list.toArray(bufferArr);
        for (int i = 0; i < bufferArr.length; i++) {
            ByteBuffer buffer =  bufferArr[i];
            while (buffer.hasRemaining()) {
                System.out.print(buffer.get() + " ");
            }
            System.out.println();
        }
    }
}
