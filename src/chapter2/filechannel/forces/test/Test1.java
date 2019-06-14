package chapter2.filechannel.forces.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test1 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test20.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
        }
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        long beginTime = System.currentTimeMillis();
        for (int i = 0;i < 5000;i++) {
            channel.write(ByteBuffer.wrap("abcde".getBytes()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        channel.close();
    }

}
