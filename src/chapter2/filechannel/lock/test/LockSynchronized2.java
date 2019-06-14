package chapter2.filechannel.lock.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class LockSynchronized2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("D:\\test19.txt", "rw");
        FileChannel channel = file.getChannel();
        System.out.println("B begin");
        channel.lock(1, 2, false);
        System.out.println("B end");
        Thread.sleep(Integer.MAX_VALUE);
        channel.close();
        file.close();
    }
}
