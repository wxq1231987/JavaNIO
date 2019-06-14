package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExclusiveSelfCanRead {
    /**
     * 验证独占锁自己能读
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\test15.txt", "rw");
        FileChannel channel = file.getChannel();
        channel.lock(1, 2, false);
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        channel.close();
        file.close();
    }
}
