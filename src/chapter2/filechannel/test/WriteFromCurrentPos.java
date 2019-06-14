package chapter2.filechannel.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteFromCurrentPos {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\test.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap("abcdefg".getBytes());
        System.out.println("A channel position=" + channel.position());
        channel.write(buffer);
        System.out.println("B channel position=" + channel.position());
        channel.position(2);
        buffer.rewind();
        channel.write(buffer);
        System.out.println("C channel position=" + channel.position());
    }

}
