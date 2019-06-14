package chapter2.filechannel.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadToCurrentPos {
    private static FileInputStream fis;
    private static FileChannel channel;
    /**
     * 验证将读取到的字节放在Buffer的当前位置
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream("D:\\test.txt");
        channel = fis.getChannel();
        channel.position(2);
        ByteBuffer buffer = ByteBuffer.allocate(7);
        buffer.position(3);
        int readLength = channel.read(buffer);
        if (readLength > 0) {
            byte[] array = buffer.array();
            for (int i = 0;i < array.length;i++) {
                if (array[i] == 0) {
                    System.out.print("空格" + " ");
                } else {
                    System.out.print((char) array[i] + " ");
                }
            }
        }
    }

}
