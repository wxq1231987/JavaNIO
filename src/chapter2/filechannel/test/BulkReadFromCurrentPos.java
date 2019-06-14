package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 验证批量操作是从通道的当前位置开始读取的
 * @author Wang XuQin
 *
 */
public class BulkReadFromCurrentPos {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream(new File("D:\\test8.txt"));
        channel = fis.getChannel();

        channel.position(2);
        ByteBuffer buffer1 = ByteBuffer.allocate(2);
        ByteBuffer buffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};

        channel.read(bufferArr);

        for (int j = 0;j < bufferArr.length;j++) {
            byte[] getByte = bufferArr[j].array();
            for (int k = 0;k < getByte.length;k++) {
                System.out.print((char)getByte[k] + "&");
            }
            System.out.println();
        }
    }

}
