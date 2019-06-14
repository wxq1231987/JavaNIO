package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BulkReadLength {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream(new File("D:\\test8.txt"));
        channel = fis.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(2);
        ByteBuffer buffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};

        long readLength = channel.read(bufferArr);
        System.out.println(readLength);
        System.out.println("A channel position=" + channel.position());
        buffer1.clear();
        buffer2.clear();

        readLength = channel.read(bufferArr);
        System.out.println(readLength);
        System.out.println("B channel position=" + channel.position());
        buffer1.clear();
        buffer2.clear();

        readLength = channel.read(bufferArr);
        System.out.println(readLength);
        System.out.println("C channel position=" + channel.position());
        buffer1.clear();
        buffer2.clear();
    }

}
