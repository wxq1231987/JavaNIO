package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadDataMoreRemaing {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream(new File("D:\\test3.txt"));
        channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(3);
        System.out.println("A1 channel position=" + channel.position() + ", limit=" + channel.size());
        System.out.println("A2 buffer position=" + buffer.position() + ", limit=" + buffer.limit());
        int readLength = channel.read(buffer);
        System.out.println("B1 channel position=" + channel.position() + ", limit=" + channel.size());
        System.out.println("B2 buffer position=" + buffer.position() + ", limit=" + buffer.limit());
        System.out.println(new String(buffer.array(), 0, readLength));
    }
}
