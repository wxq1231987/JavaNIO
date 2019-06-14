package chapter2.filechannel.lock.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SharedLockSelfRead {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\test15.txt", "rw");
        FileChannel channel = file.getChannel();
        channel.lock(1, 2, true);
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        buffer.flip();
        for (int i = 0;i < buffer.limit();i++) {
            System.out.print((char) buffer.get());
        }
    }

}
