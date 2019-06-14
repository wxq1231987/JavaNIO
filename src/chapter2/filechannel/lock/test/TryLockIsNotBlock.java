package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class TryLockIsNotBlock {

    public static void main(String[] args) throws IOException, InterruptedException {
        /*RandomAccessFile fileA = new RandomAccessFile("D:\\test16.txt", "rw");*/
        FileOutputStream fileA = new FileOutputStream("D:\\test16.txt");
        RandomAccessFile fileB = new RandomAccessFile("D:\\test16.txt", "rw");
        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                System.out.println("A begin");
                FileLock lock = null;
                try {
                    lock = channelA.tryLock(1, 2, false);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (lock != null) {
                    System.out.println("A gets lock");
                } else {
                    System.out.println("A doesn't get lock");
                }
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        /*Thread threadB = new Thread() {
            @Override
            public void run() {
                FileLock lock = null;
                System.out.println("B begin get lock");
                try {
                    lock = channelB.tryLock(1, 2, true);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                if (lock != null) {
                    System.out.println("B gets lock");
                } else {
                    System.out.println("B doesn't get lock");
                }
            }
        };*/
        threadA.start();
        //threadB.start();
        Thread.sleep(3000);
        channelA.close();
        channelB.close();
        fileA.close();
        fileB.close();
    }

}
