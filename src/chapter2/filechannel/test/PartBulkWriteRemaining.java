package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PartBulkWriteRemaining {

    /**
     * 验证write(buffer[], offset, length)将Buffer的Remaing写入通道
     */
    private static FileOutputStream fos;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fos = new FileOutputStream(new File("D:\\test10.txt"));
        channel = fos.getChannel();

        ByteBuffer buffer1 = ByteBuffer.wrap("123456".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("abcdef".getBytes());
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};

        buffer1.position(2);
        buffer1.limit(5);
        buffer2.position(1);
        buffer2.limit(6);

        channel.write(bufferArr, 0, 2);

        channel.close();
        fos.close();
    }

}
