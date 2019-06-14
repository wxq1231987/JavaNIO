package chapter2.filechannel.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PositionExceedSize {

    public static void main(String[] args) throws IOException {
        /*FileInputStream fis = new FileInputStream(new File("D:\\test12.txt"));
        FileChannel channel = fis.getChannel();
        channel.position(9);
        ByteBuffer buffer = ByteBuffer.allocate(5);
        channel.read(buffer);*/
        RandomAccessFile file = new RandomAccessFile("D:\\test12.txt", "rw");
        FileChannel channel = file.getChannel();
        System.out.println("A position=" + channel.position() + ", size=" + channel.size());
        channel.position(18);
        channel.write(ByteBuffer.wrap("abc".getBytes()));
        System.out.println("Channel position=" + channel.position() + ", size=" + channel.size());
        System.out.println(channel.read(ByteBuffer.allocate(100), 21));
        channel.close();
        file.close();
    }

}
