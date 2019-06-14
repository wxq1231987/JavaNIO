package chapter2.filechannel.lock.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExclusiveSelfCanWrite {

    /**
     * 验证独占锁自己能写
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        /**
         * 验证共享锁自己不能写到锁定的区域
         */
        RandomAccessFile file = new RandomAccessFile("D:\\test15.txt", "rw");
        FileChannel channel = file.getChannel();
        channel.lock(1, 2, false);
        channel.write(ByteBuffer.wrap("123456".getBytes()));
        channel.close();
        file.close();
    }

}
