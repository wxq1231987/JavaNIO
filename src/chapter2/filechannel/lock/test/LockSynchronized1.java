package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class LockSynchronized1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("D:\\test19.txt", "rw");
        FileChannel channel = file.getChannel();
        System.out.println("A begin");
        channel.lock(1, 2, false);
        System.out.println("A end");
        Thread.sleep(Integer.MAX_VALUE);
        channel.close();
        file.close();
    }

}
