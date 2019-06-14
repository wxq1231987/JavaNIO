package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileInteruptionExceptionTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        FileOutputStream file = new FileOutputStream("D:\\test.19.txt");
        FileChannel channel = file.getChannel();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0;i < 100000;i++) {
                        System.out.println("i=" + i);
                    }
                    channel.lock(1, 2, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        threadA.start();
        Thread.sleep(50);
        threadA.interrupt();
        Thread.sleep(30000);
        channel.close();
        file.close();
    }

}
