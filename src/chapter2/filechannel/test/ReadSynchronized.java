package chapter2.filechannel.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class ReadSynchronized {
    private static FileInputStream fis;
    private static FileChannel channel;
    public static void main(String[] args) throws IOException, InterruptedException {
        fis = new FileInputStream("D:\\test4.txt");
        channel = fis.getChannel();
        for (int i = 0;i < 10;i++) {
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer = ByteBuffer.allocate(8);
                    int readLength = -1;
                    try {
                        readLength = channel.read(buffer);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(new String(buffer.array(), 0, readLength));
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer buffer = ByteBuffer.allocate(8);
                    int readLength = -1;
                    try {
                        readLength = channel.read(buffer);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    /*buffer.rewind();
                    byte[] array = buffer.array();
                    if (readLength > 0) {
                        for (int i = 0;i < array.length;i++) {
                            System.out.print((char) array[i]);
                        }
                    }*/
                    System.out.println(new String(buffer.array(), 0, readLength));
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
