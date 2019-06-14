package chapter2.filechannel.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 验证从通道的当前位置写入
 * @author Wang XuQin
 *
 */
public class BulkWriteToCurrentPos {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\test5.txt"));
        FileChannel channel = fos.getChannel();
        channel.write(ByteBuffer.wrap("123456".getBytes()));
        channel.position(3);
        ByteBuffer buffer1 = ByteBuffer.wrap("oooo1".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("aaaa1".getBytes());
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
        channel.write(bufferArr);
    }

}
