package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteSpecPosToSpecPos {

    /**
     * 验证write(ByteBuffer, long)方法是从通道的指定位置写入的
     */
    private static FileOutputStream fos;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fos = new FileOutputStream(new File("D:\\test12.txt"));
        channel = fos.getChannel();

        ByteBuffer buffer1 = ByteBuffer.wrap("123456".getBytes());
        System.out.println("A channel position=" + channel.position() + ", size=" + channel.size());
        channel.write(buffer1, 0);
        System.out.println("B channel position=" + channel.position() + ", size=" + channel.size());
        System.out.println("C buffer position=" + buffer1.position() + ", limit=" + buffer1.limit());
        buffer1.rewind();
        channel.write(buffer1, 2);
        channel.close();
        fos.close();
    }

}
