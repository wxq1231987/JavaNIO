package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 验证共享锁他人也不能写
 * @author Wang XuQin
 *
 */
public class SharedLockOtherNotWrite {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile fileA = new RandomAccessFile("D:\\test.19.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("D:\\test.19.txt", "rw");
        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    channelA.lock(1, 2, true);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    channelB.write(ByteBuffer.wrap("123456".getBytes()));
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
