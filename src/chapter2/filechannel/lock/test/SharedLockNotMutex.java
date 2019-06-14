package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class SharedLockNotMutex {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile fileA = new RandomAccessFile("D:\\test14.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("D:\\test14.txt", "rw");
        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Channel A begin lock");
                    channelA.lock(0, Long.MAX_VALUE, true);
                    System.out.println("Channel A end lock");
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (IOException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Channel B begin lock");
                    channelB.lock(0, Long.MAX_VALUE, true);
                    System.out.println("Channel B end lock");
                    //Thread.sleep(Integer.MAX_VALUE);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        threadA.start();
        threadB.start();
    }
}
