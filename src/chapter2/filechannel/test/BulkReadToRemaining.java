package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 验证从通道中读取的字节放入缓冲区的remaining
 * @author Wang XuQin
 *
 */
public class BulkReadToRemaining {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream(new File("D:\\test8.txt"));
        channel = fis.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(2);
        ByteBuffer buffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
        buffer2.position(1);
        channel.read(bufferArr);

        for (int j = 0;j < bufferArr.length;j++) {
            byte[] getByte = bufferArr[j].array();
            for (int k = 0;k < getByte.length;k++) {
                if (0 == getByte[k]) {
                    System.out.print("空格");
                } else {
                    System.out.print((char)getByte[k]);
                }
                
            }
            System.out.println();
        }
    }
}
