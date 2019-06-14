package chapter2.filechannel.map.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class ReadWriteTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test9.txt");
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel channel = fileA.getChannel();
        MappedByteBuffer buffer = channel.map(MapMode.READ_WRITE, 0, 5);
        System.out.println("MappedByteBuffer position=" + buffer.position()
             + ", limit=" + buffer.limit() + ", capacity=" + buffer.capacity());
        System.out.println((char)buffer.get() + "-" + buffer.position());
        System.out.println((char)buffer.get() + "-" + buffer.position());
        System.out.println((char)buffer.get() + "-" + buffer.position());
        System.out.println((char)buffer.get() + "-" + buffer.position());
        System.out.println((char)buffer.get() + "-" + buffer.position());

        buffer.position(0);
        buffer.put((byte) '1');
        buffer.put((byte) '2');
        buffer.put((byte) '3');
        buffer.put((byte) '4');
        buffer.put((byte) '5');

        channel.close();
        fileA.close();
    }

}
