package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class AsynchronousCloseExceptionTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        FileOutputStream file = new FileOutputStream("D:\\test.19.txt");
        FileChannel channel = file.getChannel();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    channel.lock(1, 2, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        threadA.start();
        Thread.sleep(1);
        threadB.start();
        Thread.sleep(1000);
        channel.close();
        file.close();
    }

}
