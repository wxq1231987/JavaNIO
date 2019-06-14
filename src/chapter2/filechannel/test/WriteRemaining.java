package chapter2.filechannel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteRemaining {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\test2.txt"));
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer1 = ByteBuffer.wrap("abcdefg".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("123".getBytes());
        buffer1.position(2);
        buffer2.position(1);
        channel.write(buffer1);
        channel.write(buffer2);
        System.out.println("A buffer1" + buffer1.position() + "," + buffer1.limit());
    }
}
