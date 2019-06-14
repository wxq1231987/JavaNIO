package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BukWriteSynchronized {

    /**
     * 验证write方法有同步性
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\test7.txt"));
        FileChannel channel = fos.getChannel();
        for (int i = 0;i < 10;i++) {
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer1 = ByteBuffer.wrap("aaaaa1\r\n".getBytes());
                    ByteBuffer buffer2 = ByteBuffer.wrap("bbbbb1\r\n".getBytes());
                    ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
                    try {
                        channel.write(bufferArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer1 = ByteBuffer.wrap("ccccc1\r\n".getBytes());
                    ByteBuffer buffer2 = ByteBuffer.wrap("ddddd1\r\n".getBytes());
                    ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
                    try {
                        channel.write(bufferArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }

}
