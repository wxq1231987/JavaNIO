package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 验证将ByteBuffer中的remaining写入通道
 * @author Wang XuQin
 *
 */
public class BulkWriteRemaining {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\test6.txt"));
        FileChannel channel = fos.getChannel();

        channel.write(ByteBuffer.wrap("123456".getBytes()));
        channel.position(3);

        ByteBuffer buffer1 = ByteBuffer.wrap("abcde1".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("higklmnop".getBytes());
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};

        buffer1.position(1);
        buffer2.position(4);
        buffer2.limit(7);

        channel.write(bufferArr);

        channel.close();
        fos.close();
    }
}
