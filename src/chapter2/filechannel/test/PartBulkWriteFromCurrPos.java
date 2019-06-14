package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PartBulkWriteFromCurrPos {
    /**
     * 部分批量写操作是从通道的当前位置开始写入的
     * @param args
     */
    private static FileOutputStream fos;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fos = new FileOutputStream(new File("D:\\test9.txt"));
        channel = fos.getChannel();

        ByteBuffer buffer1 = ByteBuffer.wrap("123456".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("abcdef".getBytes());
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};

        System.out.println("A channel position=" + channel.position());
        channel.write(bufferArr, 1, 1);
        System.out.println("B channel position=" + channel.position());

        channel.close();
        fos.close();
    }

}
