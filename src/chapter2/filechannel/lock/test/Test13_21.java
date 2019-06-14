package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_21 {

    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile file = new RandomAccessFile("D:\\test15.txt", "rw");
        FileChannel channel = file.getChannel();
        try {
            System.out.println("begin");
            channel.lock(0, Long.MAX_VALUE, true);
            System.out.println("end 拿到锁了");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
