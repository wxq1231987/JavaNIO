package chapter2.filechannel.map.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class LoadTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test9.txt");
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel channel = fileA.getChannel();
        MappedByteBuffer buffer = channel.map(MapMode.READ_WRITE, 0, 5);
        System.out.println("buffer:" + buffer.isLoaded());
        buffer.load();
        System.out.println("buffer:" + buffer.isLoaded());
        channel.close();
        fileA.close();
    }
}
