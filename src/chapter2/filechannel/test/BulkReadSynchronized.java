package chapter2.filechannel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BulkReadSynchronized {
    /**
     * 验证批量读取操作具有同步性
     * @param args
     */
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException, InterruptedException {
        fis = new FileInputStream(new File("D:\\test7.txt"));
        channel = fis.getChannel();

        for (int i = 0;i < 10;i++) {
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer1 = ByteBuffer.allocate(8);
                    ByteBuffer buffer2 = ByteBuffer.allocate(8);
                    ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
                    try {
                        long readLength = channel.read(bufferArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new String(bufferArr[0].array())
                            + new String(bufferArr[1].array()));
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer1 = ByteBuffer.allocate(8);
                    ByteBuffer buffer2 = ByteBuffer.allocate(8);
                    ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
                    try {
                        long readLength = channel.read(bufferArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new String(bufferArr[0].array())
                            + new String(bufferArr[1].array()));
                }
            };
            thread1.start();
            thread2.start();
        }
        Thread.sleep(3000);
        channel.close();
        fis.close();
    }

}
