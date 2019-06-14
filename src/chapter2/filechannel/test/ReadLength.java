package chapter2.filechannel.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadLength {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException {
        fis = new FileInputStream("D:\\test.txt");
        channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(9);
        int readLength = channel.read(buffer);
        System.out.println(readLength);
        readLength = channel.read(buffer);
        System.out.println(readLength);
        buffer.rewind();
        readLength = channel.read(buffer);
        System.out.println(readLength);
    }
}
