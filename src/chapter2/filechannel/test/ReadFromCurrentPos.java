package chapter2.filechannel.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 验证从此通道的当前位置读入到给定的缓冲区
 * @author Wang XuQin
 *
 */
public class ReadFromCurrentPos {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream("D:\\test.txt");
        channel = fis.getChannel();
        channel.position(2);
        ByteBuffer buffer = ByteBuffer.allocate(4);
        int readLength = channel.read(buffer);
        System.out.println(readLength);
        if (readLength > 0) {
            byte[] array = buffer.array();
            for (int i = 0;i < array.length;i++) {
                System.out.print((char)array[i]);
            }
        }
    }
}
