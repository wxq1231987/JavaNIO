package chapter1.buffer.test;

import java.nio.ByteBuffer;
/**
 * Slice()方法生成的ByteBuffer用array方法返回的数组和之前的相同
 * @author Wang XuQin
 *
 */
public class SliceTest {
    public static void main(String[] args) {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ByteBuffer buffer1 = ByteBuffer.wrap(array);
        buffer1.position(5);
        ByteBuffer buffer2 = buffer1.slice();
        System.out.println("buffer1 position=" + buffer1.position()
                 + ", capacity=" + buffer1.capacity() 
                 + ", limit=" + buffer1.limit());
        System.out.println("buffer2 position=" + buffer2.position()
        + ", capacity=" + buffer2.capacity() 
        + ", limit=" + buffer2.limit());
        buffer2.put(0, (byte) 112);
        byte[] byteArr1 = buffer1.array();
        byte[] byteArr2 = buffer2.array();
        for (int i = 0; i < byteArr1.length; i++) {
            System.out.print(byteArr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < byteArr2.length; i++) {
            System.out.print(byteArr2[i] + " ");
        }
    }
}
