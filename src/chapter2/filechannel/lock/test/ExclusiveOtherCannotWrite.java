package chapter2.filechannel.lock.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 验证独占锁他人不能写
 * @author Wang XuQin
 *
 */
public class ExclusiveOtherCannotWrite {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("D:\\test.19.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("D:\\test.19.txt", "rw");
        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    channelA.lock(1, 2, false);
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

        Thread.sleep(3000);
        channelA.close();
        channelB.close();
        fileA.close();
        fileB.close();
    }
}
