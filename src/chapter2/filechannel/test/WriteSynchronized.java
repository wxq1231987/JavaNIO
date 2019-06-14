package chapter2.filechannel.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteSynchronized {
    private static FileOutputStream fos;
    private static FileChannel channel;
    public static void main(String[] args) throws InterruptedException, IOException {
        fos = new FileOutputStream("D:\\test3.txt");
        channel = fos.getChannel();
        for (int i = 0;i < 10;i++) {
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer = ByteBuffer.wrap("abcdef\r\n".getBytes());
                    try {
                        channel.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer = ByteBuffer.wrap("我是中国人\r\n".getBytes());
                    try {
                        channel.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
        Thread.sleep(3000);
        channel.close();
    }
}
