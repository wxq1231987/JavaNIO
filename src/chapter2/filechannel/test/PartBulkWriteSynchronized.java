package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PartBulkWriteSynchronized {

    private static FileOutputStream fos;
    private static FileChannel channel;
    private static int count = 0;
    synchronized public static ByteBuffer[] getByteBufferArray(String printStr1, String printStr2) {
        ++count;
        ByteBuffer buffer1 = ByteBuffer.wrap((printStr1 + count + "\r\n").getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap((printStr2 + count + "\r\n").getBytes());
        ByteBuffer[] bufferArr = new ByteBuffer[]{buffer1, buffer2};
        return bufferArr;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        fos = new FileOutputStream(new File("D:\\test11.txt"));
        channel = fos.getChannel();

        for (int i = 0;i < 10;i++) {
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer[] bufferArr = getByteBufferArray("aaaaa", "bbbbb");
                    try {
                        channel.write(bufferArr, 0, 2);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer[] bufferArr = getByteBufferArray("xxxxx", "yyyyy");
                    try {
                        channel.write(bufferArr, 0, 2);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
        Thread.sleep(3000);
        channel.close();
        fos.close();
    }

}
